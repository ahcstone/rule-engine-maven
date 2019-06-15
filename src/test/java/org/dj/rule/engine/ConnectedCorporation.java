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

/**
 * <p>
 * 关联法人信息
 * @author  AHC.Jake
 * @version 1.0, 2019年6月16日
 */
public class ConnectedCorporation  implements Serializable{

    private static final long serialVersionUID = 7590967812044967042L;
    //记录标识
    private String id;
    //法人名称
    private String name;
    //法人证件号码
    private String cardNo;

    //是否属于银监会规定的关联方
    private boolean isBankConnected;
    //是否属于内地交易所规定的关联方
    private boolean isStockConnected;
    //是否属于联交所规定的关联方
    private boolean isHstockConnected;
    //是否属于会计准则规定的关联方
    private boolean isAccountingConnected;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCardNo() {
        return cardNo;
    }
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
    public boolean isBankConnected() {
        return isBankConnected;
    }
    public void setBankConnected(boolean isBankConnected) {
        this.isBankConnected = isBankConnected;
    }
    public boolean isStockConnected() {
        return isStockConnected;
    }
    public void setStockConnected(boolean isStockConnected) {
        this.isStockConnected = isStockConnected;
    }
    public boolean isHstockConnected() {
        return isHstockConnected;
    }
    public void setHstockConnected(boolean isHstockConnected) {
        this.isHstockConnected = isHstockConnected;
    }
    public boolean isAccountingConnected() {
        return isAccountingConnected;
    }
    public void setAccountingConnected(boolean isAccountingConnected) {
        this.isAccountingConnected = isAccountingConnected;
    }
  

}