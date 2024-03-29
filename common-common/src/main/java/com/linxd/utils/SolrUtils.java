package com.linxd.utils;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linxd
 * @date 2019/11/10 2:03
 * Description: No Description
 */
@Slf4j
@Data
@Component()
@Scope("prototype")
public class SolrUtils<T> {
    /**
     *要查询的数据库
     */
    private String core;

    @Autowired
    private SolrClient solrClient;

    public Object queryById(Integer id) {
        checkCore();
        try {
            return solrClient.getById(id.toString());
        } catch (IOException | SolrServerException e) {
            log.error(e.getMessage());
        }
        return null;
    }

    public <T> List<T> queryFromSolr(Map<String,Object> params
            , Class<T> tClass, Integer page, Integer size) {
        checkCore();
        SolrQuery solrQuery = new SolrQuery();
        if (params != null && params.size() > 0) {

            Set<String> keys = params.keySet();
            StringBuilder sb = new StringBuilder("");
            int index = 1;
            for (String key : keys) {
                Object value = params.get(key);
                if (value == null) {
                    value = "*";
                }
                if (index == 1) {
                    sb.append(key + ":" + value);
                    index++;
                } else {
                    sb.append(" OR " + key + ":" + value);
                }

            }

            solrQuery.setQuery(sb.toString());
        } else {
            solrQuery.setQuery("* : *");
        }
        int start = (page - 1) * size;
        solrQuery.setStart(start < 0 ? 0 : start);
        solrQuery.setRows(size);
        QueryResponse response = null;
        try {
            response = solrClient.query(core, solrQuery);
        } catch (IOException | SolrServerException e) {
            log.error(e.getMessage());
        }
        log.info("调用solr查询=======================================================");
        List<T> beanList = response.getBeans(tClass);
        return beanList;
    }

    public void addList(List<T> beans) {
        checkCore();
        try {
            solrClient.addBeans(beans);
            solrClient.commit();
        } catch (SolrServerException | IOException e) {
            log.error(e.getMessage());
        }
    }

    public void addOne(Object bean) {
        checkCore();
        try {
            solrClient.addBean(bean);
            solrClient.commit();
        } catch (SolrServerException | IOException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * 检查core是否为空
     * @return 不为空返回true
     */
    private void checkCore() {
        if (!(core != null && core.length() > 0)) {
            throw new RuntimeException("core为空");
        }
    }

}
