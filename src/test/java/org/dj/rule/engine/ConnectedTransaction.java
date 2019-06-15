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

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.List;

/**
 * <p>
 * 关联交易信息
 * @author  AHC.Jake
 * @version 1.0, 2019年6月16日
 */
public class ConnectedTransaction  implements Serializable{

    private static final long serialVersionUID = 7590967812044967041L;
    //记录标识
    private String id;
    //关联交易 交易编号
    private String tradeNo;
    //源系统业务名称
    private String srcSystemName;
    //股权质押名称
    private String pledgeName;
    //担保方式
    private String guaranteeType;
    //五级分类
    private String fiveType;
     
    //交易余额
    private int tradeBalance;
    //资本净额
    private int netCapital;
    
    //关联交易 交易金额
    private int tradeSum;
    
    //内地交易所 关联方持股比例 INSTO
    private int insto;
    
    //关联方类型  比如 关联法人/关联自然人
    private String connectedType;
    //关联方名称
    private String connectedName;
    //关联方证件号码
    private String connectedCardNo;

    //银监会的关联交易分类
    private String cbrcTradeType;
    //内地交易所的关联交易分类
    private String meTradeType;
    
    //是否属于银监会规定的关联交易
    private boolean cbrcConnected;
    //是否属于银监会规定的禁止类关联交易
    private boolean cbrcProhibit = false;

    //是否属于内地交易所规定的关联交易
    private boolean meConnected;
    //是否属于银监会规定的禁止类关联交易
    private boolean meProhibit = false;
    
    //交易日期
    private Date tradeDate;
    
    //触发规则名称
    private String ruleName;
    //触发规则提示信息
    private String ruleMessage;
    
    private List<Map<String,String>> firedRules;
    
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTradeNo() {
        return tradeNo;
    }
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }
    public String getSrcSystemName() {
        return srcSystemName;
    }
    public void setSrcSystemName(String srcSystemName) {
        this.srcSystemName = srcSystemName;
    }
    public String getPledgeName() {
        return pledgeName;
    }
    public void setPledgeName(String pledgeName) {
        this.pledgeName = pledgeName;
    }
    public String getGuaranteeType() {
        return guaranteeType;
    }
    public void setGuaranteeType(String guaranteeType) {
        this.guaranteeType = guaranteeType;
    }
    public String getFiveType() {
        return fiveType;
    }
    public void setFiveType(String fiveType) {
        this.fiveType = fiveType;
    }
    public int getTradeBalance() {
        return tradeBalance;
    }
    public void setTradeBalance(int tradeBalance) {
        this.tradeBalance = tradeBalance;
    }
    public int getNetCapital() {
        return netCapital;
    }
    public void setNetCapital(int netCapital) {
        this.netCapital = netCapital;
    }
    public int getTradeSum() {
        return tradeSum;
    }
    public void setTradeSum(int tradeSum) {
        this.tradeSum = tradeSum;
    }
    public String getConnectedName() {
        return connectedName;
    }
    public void setConnectedName(String connectedName) {
        this.connectedName = connectedName;
    }
    public String getConnectedCardNo() {
        return connectedCardNo;
    }
    public void setConnectedCardNo(String connectedCardNo) {
        this.connectedCardNo = connectedCardNo;
    }
    public String getCbrcTradeType() {
        return cbrcTradeType;
    }
    public void setCbrcTradeType(String cbrcTradeType) {
        this.cbrcTradeType = cbrcTradeType;
    }
    public String getMeTradeType() {
        return meTradeType;
    }
    public void setMeTradeType(String meTradeType) {
        this.meTradeType = meTradeType;
    }
    public boolean isCbrcConnected() {
        return cbrcConnected;
    }
    public void setCbrcConnected(boolean cbrcConnected) {
        this.cbrcConnected = cbrcConnected;
    }
    public boolean isCbrcProhibit() {
        return cbrcProhibit;
    }
    public void setCbrcProhibit(boolean cbrcProhibit) {
        this.cbrcProhibit = cbrcProhibit;
    }
    public boolean isMeConnected() {
        return meConnected;
    }
    public void setMeConnected(boolean meConnected) {
        this.meConnected = meConnected;
    }
    public boolean isMeProhibit() {
        return meProhibit;
    }
    public void setMeProhibit(boolean meProhibit) {
        this.meProhibit = meProhibit;
    }
    public String getRuleName() {
        return ruleName;
    }
    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }
    public String getRuleMessage() {
        return ruleMessage;
    }
    public void setRuleMessage(String ruleMessage) {
        this.ruleMessage = ruleMessage;
    }
    public Date getTradeDate() {
        return tradeDate;
    }
    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }
    public List<Map<String,String>> getFiredRules() {
        return firedRules;
    }
    public void setFiredRules(List<Map<String,String>> firedRules) {
        this.firedRules = firedRules;
    }
    public int getInsto() {
        return insto;
    }
    public void setInsto(int insto) {
        this.insto = insto;
    }
    public String getConnectedType() {
        return connectedType;
    }
    public void setConnectedType(String connectedType) {
        this.connectedType = connectedType;
    }
    
    
  

}

