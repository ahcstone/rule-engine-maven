/*
 * Copyright 2018-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package org.dj.rule.engine.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.kie.api.KieBase;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.dj.rule.engine.RulesEngine;

/**
 * <p>
 * 规则引擎接口的drools-v7.11.0实现
 * @author  AHC.Jake
 * @version 1.0, 2019年6月13日
 */
@SuppressWarnings("rawtypes")
public class DroolsEngineImpl implements RulesEngine {
    
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean verifyRuleByCode(String ruleCode) {
        boolean result = true;
        
        KieHelper kieHelper = new KieHelper();
//      String ruleContent = dbservice.getRuleByCode(ruleCode);
//      String ruleContent = "";
//      kieHelper.addContent(ruleContent,ResourceType.DRL);
        kieHelper.addResource(ResourceFactory.newClassPathResource("org/dj/rule/engine/"+ruleCode+".drl"), ResourceType.DRL);
        
        Results results = kieHelper.getKieContainer().verify();
        
        List<Message> messages = results.getMessages();
        
        logger.debug("messages size:" + messages.size());
        if(messages.size()==0) {
            return result;
        }else {
            for (Message msg : messages) {
                logger.warn("Rule error level:" + msg.getLevel() + "; text=" + msg.getText());
            }
            return false;
        }
    }

    @Override
    public Object calcFactByRuleCode(String ruleCode, Object fact) {
        Object result = null;
        KieHelper kieHelper = new KieHelper();
//        String ruleContent = dbservice.getRuleByCode(ruleCode);
//        String ruleContent = "";
//        kieHelper.addContent(ruleContent,ResourceType.DRL);
        kieHelper.addResource(ResourceFactory.newClassPathResource("org/dj/rule/engine/"+ruleCode+".drl"), ResourceType.DRL);
        try{
            
            KieBase kieBase = kieHelper.build();
            KieSession kieSession = kieBase.newKieSession();
            kieSession.insert(fact);
            int count = kieSession.fireAllRules();
            
            if(count>0) {
                QueryResults queryResults = kieSession.getQueryResults("query-result");
                System.out.println("queryResults size is " + queryResults.size());
                for(QueryResultsRow row : queryResults){
                    result = row.get("$returnObj");
                }
            }
            kieSession.dispose();
            return result;
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return result;        

    }

    @Override
    public Object calcFactByRuleCode(String ruleCode, Object fact, Map params) {
        Object result = null;
        KieHelper kieHelper = new KieHelper();
//        String ruleContent = dbservice.getRuleByCode(ruleCode);
//        String ruleContent = "";
//        kieHelper.addContent(ruleContent,ResourceType.DRL);
        kieHelper.addResource(ResourceFactory.newClassPathResource("org/dj/rule/engine/"+ruleCode+".drl"), ResourceType.DRL);
        try{
            
            KieBase kieBase = kieHelper.build();
            KieSession kieSession = kieBase.newKieSession();
            kieSession.insert(fact);
            kieSession.insert(params);
            
            int count = kieSession.fireAllRules();
            
            if(count>0) {
                QueryResults queryResults = kieSession.getQueryResults("query-result");
                System.out.println("queryResults size is " + queryResults.size());
                for(QueryResultsRow row : queryResults){
                    result = row.get("$returnObj");
                }
            }
            kieSession.dispose();
            return result;
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return result;        
    }

    @Override
    public List calcFactListByRuleCode(String ruleCode, List factList) {
        List<Object> result = new ArrayList<Object>();
        
        if(ruleCode == null || ruleCode.trim().equalsIgnoreCase("")) {
            logger.warn("RuleCode is null or empty!");
            return result;
        }
        
        if (factList == null || factList.isEmpty()) {
            logger.warn("FactList is null or empty!");
            return result;
        }
        
        KieHelper kieHelper = new KieHelper();
//      String ruleContent = dbservice.getRuleByCode(ruleCode);
//      String ruleContent = "";
//      kieHelper.addContent(ruleContent,ResourceType.DRL);
        kieHelper.addResource(ResourceFactory.newClassPathResource("org/dj/rule/engine/" + ruleCode + ".drl"),
                ResourceType.DRL);
        KieBase kieBase = kieHelper.build();
        KieSession kieSession = kieBase.newKieSession();

        if (kieSession != null) {
            try {
                for (Object fact : factList) {
                    kieSession.insert(fact);
                }
                kieSession.fireAllRules();
                QueryResults queryResults = kieSession.getQueryResults("query-result");
                logger.debug("rule query results size is " + queryResults.size());
                for (QueryResultsRow row : queryResults) {
                    result.add(row.get("$returnObj"));
                }
                return result;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                kieSession.dispose();
            }
        }
        return result;
    }

    @Override
    public List calcFactListByRuleCode(String ruleCode, List factList, Map params) {
        List<Object> result = new ArrayList<Object>();
        
        if(ruleCode == null || ruleCode.trim().equalsIgnoreCase("")) {
            logger.warn("RuleCode is null or empty!");
            return result;
        }
        
        if (factList == null || factList.isEmpty()) {
            logger.warn("FactList is null or empty!");
            return result;
        }
        
        KieHelper kieHelper = new KieHelper();
//      String ruleContent = dbservice.getRuleByCode(ruleCode);
//      String ruleContent = "";
//      kieHelper.addContent(ruleContent,ResourceType.DRL);
        kieHelper.addResource(ResourceFactory.newClassPathResource("org/dj/rule/engine/" + ruleCode + ".drl"),
                ResourceType.DRL);
        KieBase kieBase = kieHelper.build();
        KieSession kieSession = kieBase.newKieSession();

        if (kieSession != null) {
            try {
                for (Object fact : factList) {
                    kieSession.insert(fact);
                }
                kieSession.insert(params);
                kieSession.fireAllRules();
                QueryResults queryResults = kieSession.getQueryResults("query-result");
                logger.debug("rule query results size is " + queryResults.size());
                for (QueryResultsRow row : queryResults) {
                    result.add(row.get("$returnObj"));
                }
                return result;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                kieSession.dispose();
            }
        }
        return result;
    }

}

