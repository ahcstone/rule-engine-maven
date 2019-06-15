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


package org.dj.rule.engine;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import org.dj.rule.engine.RulesEngine;
import org.dj.rule.engine.impl.DroolsEngineImpl;
import org.dj.rule.engine.ConnectedCorporation;
import org.dj.rule.engine.ConnectedTransaction;
/**
 * <p>
 * 规则引擎测试类
 * @author  AHC.Jake
 * @version 1.0, 2019年6月16日
 */
public class RulesEngineTest {
    /**
     * 测试内地 关联交易规则
     */
    @Test
    public void testME(){
        ConnectedTransaction fact = new ConnectedTransaction();
        fact.setId("2");
        fact.setConnectedName("腾讯公司");
        fact.setConnectedCardNo("0002");
        fact.setTradeSum(100);
        fact.setTradeBalance(6000);
        fact.setNetCapital(10000);
        
        fact.setMeConnected(true);
        fact.setTradeDate(new Date());
        //fact.setCbrcTradeType("授信");
        fact.setFiredRules(new ArrayList<Map<String, String>>());
        fact.setSrcSystemName("授信业务");
        fact.setFiveType("损失");
        
        RulesEngine engine = new DroolsEngineImpl();
        
        ConnectedTransaction result = (ConnectedTransaction)engine.calcFactByRuleCode("ME", fact);
        if(result != null) {
//            System.out.println("--------test ME-触发指标名称："+result.getRuleName());
//            System.out.println("--------test ME-提示信息："+result.getRuleMessage());
            System.out.println("--------test ME-触发规则条数："+result.getFiredRules().size());
            for(Map<String,String> ruleMap:result.getFiredRules()) {
                ruleMap.forEach((k,v) -> {
                    System.out.println("触发规则："+k);
                    System.out.println("提示信息："+v);
                });
            }
        }
    }    
    
    
    /**
     * 测试银监会 关联交易规则
     */
    @Test
    public void testCBRC(){
        ConnectedTransaction fact = new ConnectedTransaction();
        fact.setId("1");
        fact.setConnectedName("腾讯公司");
        fact.setConnectedCardNo("0001");
        fact.setTradeSum(100);
        fact.setTradeBalance(6000);
        fact.setNetCapital(10000);
        
        fact.setCbrcConnected(true);
        fact.setTradeDate(new Date());
        //fact.setCbrcTradeType("授信");
        fact.setFiredRules(new ArrayList<Map<String, String>>());
        fact.setSrcSystemName("授信业务");
        fact.setFiveType("损失");
        
//        Calendar calendar = Calendar.getInstance();
//        Date fireDate = new Date();
//        calendar.setTime(fireDate);
//        calendar.add(Calendar.YEAR, -2);
//        Date twoYear = calendar.getTime();
//        fact.setTradeDate(twoYear);
//        Map<String,Object> paramsMap = new HashMap<>();
        //设置统计时点
        //paramsMap.put("fireDate",fireDate);
        //设置两年前时点
//        paramsMap.put("twoYear",twoYear.getTime());
//        twoYear.getTime();
//        twoYear.before(fireDate);
//        System.out.println("----twoYear.before(fireDate):"+twoYear.before(fireDate));
        
        RulesEngine engine = new DroolsEngineImpl();
        
        ConnectedTransaction result = (ConnectedTransaction)engine.calcFactByRuleCode("CBRC", fact);
        if(result != null) {
//            System.out.println("--------test CBRC-触发指标名称："+result.getRuleName());
//            System.out.println("--------test CBRC-提示信息："+result.getRuleMessage());
            System.out.println("--------test CBRC-触发规则条数："+result.getFiredRules().size());
            for(Map<String,String> ruleMap:result.getFiredRules()) {
                ruleMap.forEach((k,v) -> {
                    System.out.println("触发规则："+k);
                    System.out.println("提示信息："+v);
                });
            }
        }
    }    

    /**
     * 测试银监会 关联交易规则
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testCBRCList(){
        ConnectedTransaction fact = new ConnectedTransaction();
        fact.setId("1");
        fact.setConnectedName("腾讯公司");
        fact.setConnectedCardNo("0001");
        fact.setTradeSum(100);
        fact.setTradeBalance(1500);
        fact.setNetCapital(10000);
        
        fact.setCbrcConnected(true);
        fact.setTradeDate(new Date());
        //fact.setCbrcTradeType("授信");
        fact.setFiredRules(new ArrayList<Map<String, String>>());
        fact.setSrcSystemName("授信业务");
        fact.setFiveType("损失");
        
        ConnectedTransaction fact1 = new ConnectedTransaction();
        fact1.setId("2");
        fact1.setConnectedName("阿里");
        fact1.setConnectedCardNo("0002");
        fact1.setTradeSum(100);
        fact1.setTradeBalance(6000);
        fact1.setNetCapital(10000);
        
        fact1.setCbrcConnected(true);
        fact1.setTradeDate(new Date());
        //fact1.setCbrcTradeType("授信");
        fact1.setFiredRules(new ArrayList<Map<String, String>>());
        fact1.setSrcSystemName("授信业务");
        fact1.setFiveType("损失");    
        
        ConnectedTransaction fact2 = new ConnectedTransaction();
        fact2.setId("3");
        fact2.setConnectedName("百度");
        fact2.setConnectedCardNo("0003");
        fact2.setTradeSum(100);
        fact2.setTradeBalance(1000);
        fact2.setNetCapital(10000);
        
        fact2.setCbrcConnected(false);
        fact2.setTradeDate(new Date());
        //fact2.setCbrcTradeType("授信");
        fact2.setFiredRules(new ArrayList<Map<String, String>>());
        fact2.setSrcSystemName("授信业务");
        fact2.setFiveType("损失");
        
        List<ConnectedTransaction> factList = new ArrayList<ConnectedTransaction>();
        factList.add(fact);
        factList.add(fact1);
        factList.add(fact2);
        
        
        RulesEngine engine = new DroolsEngineImpl();

        
        List<ConnectedTransaction> resultList = (List<ConnectedTransaction>)engine.calcFactListByRuleCode("CBRC", factList);
        if(resultList != null ) {
//            System.out.println("--------test CBRC-触发指标名称："+result.getRuleName());
//            System.out.println("--------test CBRC-提示信息："+result.getRuleMessage());
            for(ConnectedTransaction result:resultList) {
                System.out.println(result.getConnectedName());
                System.out.println("--------test CBRC-触发规则条数："+result.getFiredRules().size());
                for(Map<String,String> ruleMap:result.getFiredRules()) {
                    ruleMap.forEach((k,v) -> {
                        System.out.println("触发规则："+k);
                        System.out.println("提示信息："+v);
                    });
                }
            }
        }
    }    
    
    //@Test
    public void testDemo(){
        ConnectedTransaction fact = new ConnectedTransaction();
        fact.setId("1");
        fact.setConnectedName("腾讯公司");
        fact.setConnectedCardNo("0001");
        fact.setTradeSum(1000);
        fact.setCbrcConnected(false);

        List<ConnectedCorporation> list = new ArrayList<>();
        ConnectedCorporation corp1 = new ConnectedCorporation();
        corp1.setId("0001");
        corp1.setName("腾讯公司");
        corp1.setBankConnected(true);
        list.add(corp1);
        ConnectedCorporation corp2 = new ConnectedCorporation();
        corp2.setId("0002");
        corp2.setName("阿里巴巴");
        corp2.setBankConnected(false);
        list.add(corp2);
        
        Map<String,Object> paramsMap = new HashMap<>();
        paramsMap.put("corpList",list);

        
        RulesEngine engine = new DroolsEngineImpl();
        
        ConnectedTransaction result = (ConnectedTransaction)engine.calcFactByRuleCode("demo", fact, paramsMap);
        if(result != null) {
            System.out.println("--------test demo result,是否银监会关联交易："+result.isCbrcConnected());
        }
    }
 
}

