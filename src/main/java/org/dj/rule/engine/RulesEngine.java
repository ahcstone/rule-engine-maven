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

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 规则引擎接口
 * @author  AHC.Jake
 * @version 1.0, 2019年6月13日
 */
public interface RulesEngine {

    /**
     * 验证规则是否有效
     * @param ruleCode 规则编码
     * @return 验证结果-是否有效
     */
     public boolean verifyRuleByCode(String ruleCode);

    /**
     * 计算指定规则的单个事实--规则不带输入参数
     * @param ruleCode 规则编码
     * @param fact 事实对象
     * @return 计算后的事实或其他对象(由规则返回内容决定)
     */
     public Object calcFactByRuleCode(String ruleCode, Object fact);
     
    /**
     * 计算指定规则的单个事实--规则带输入参数
     * @param ruleCode 规则编码
     * @param fact 事实对象
     * @param params 规则参数Map对象
     * @return 计算后的事实或其他对象(由规则返回内容决定)
     */
    @SuppressWarnings("rawtypes")
    public Object calcFactByRuleCode(String ruleCode, Object fact, Map params);

    /**
     * 计算指定规则的事实列表--规则不带输入参数
     * @param ruleCode 规则编码
     * @param factList 事实对象列表
     * @return 计算后的事实列表或其他对象(由规则返回内容决定)
     */
    @SuppressWarnings("rawtypes")
     public List calcFactListByRuleCode(String ruleCode, List factList);
     
    /**
     * 计算指定规则的事实列表--规则带输入参数
     * @param ruleCode 规则编码
     * @param factList 事实对象列表
     * @param params 规则参数Map对象
     * @return 计算后的事实列表或其他对象(由规则返回内容决定)
     */
    @SuppressWarnings("rawtypes")
    public List calcFactListByRuleCode(String ruleCode, List factList, Map params);

}

