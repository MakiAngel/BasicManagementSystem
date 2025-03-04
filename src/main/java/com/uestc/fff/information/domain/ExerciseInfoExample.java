package com.uestc.fff.information.domain;

import java.util.ArrayList;
import java.util.List;

public class ExerciseInfoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table exercise
     *
     * @mbg.generated Sat Sep 05 21:58:25 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table exercise
     *
     * @mbg.generated Sat Sep 05 21:58:25 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table exercise
     *
     * @mbg.generated Sat Sep 05 21:58:25 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exercise
     *
     * @mbg.generated Sat Sep 05 21:58:25 CST 2020
     */
    public ExerciseInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exercise
     *
     * @mbg.generated Sat Sep 05 21:58:25 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exercise
     *
     * @mbg.generated Sat Sep 05 21:58:25 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exercise
     *
     * @mbg.generated Sat Sep 05 21:58:25 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exercise
     *
     * @mbg.generated Sat Sep 05 21:58:25 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exercise
     *
     * @mbg.generated Sat Sep 05 21:58:25 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exercise
     *
     * @mbg.generated Sat Sep 05 21:58:25 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exercise
     *
     * @mbg.generated Sat Sep 05 21:58:25 CST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exercise
     *
     * @mbg.generated Sat Sep 05 21:58:25 CST 2020
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exercise
     *
     * @mbg.generated Sat Sep 05 21:58:25 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exercise
     *
     * @mbg.generated Sat Sep 05 21:58:25 CST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table exercise
     *
     * @mbg.generated Sat Sep 05 21:58:25 CST 2020
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andEidIsNull() {
            addCriterion("Eid is null");
            return (Criteria) this;
        }

        public Criteria andEidIsNotNull() {
            addCriterion("Eid is not null");
            return (Criteria) this;
        }

        public Criteria andEidEqualTo(String value) {
            addCriterion("Eid =", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotEqualTo(String value) {
            addCriterion("Eid <>", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidGreaterThan(String value) {
            addCriterion("Eid >", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidGreaterThanOrEqualTo(String value) {
            addCriterion("Eid >=", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidLessThan(String value) {
            addCriterion("Eid <", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidLessThanOrEqualTo(String value) {
            addCriterion("Eid <=", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidLike(String value) {
            addCriterion("Eid like", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotLike(String value) {
            addCriterion("Eid not like", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidIn(List<String> values) {
            addCriterion("Eid in", values, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotIn(List<String> values) {
            addCriterion("Eid not in", values, "eid");
            return (Criteria) this;
        }

        public Criteria andEidBetween(String value1, String value2) {
            addCriterion("Eid between", value1, value2, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotBetween(String value1, String value2) {
            addCriterion("Eid not between", value1, value2, "eid");
            return (Criteria) this;
        }

        public Criteria andCidIsNull() {
            addCriterion("Cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("Cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(String value) {
            addCriterion("Cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(String value) {
            addCriterion("Cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(String value) {
            addCriterion("Cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(String value) {
            addCriterion("Cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(String value) {
            addCriterion("Cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(String value) {
            addCriterion("Cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLike(String value) {
            addCriterion("Cid like", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotLike(String value) {
            addCriterion("Cid not like", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<String> values) {
            addCriterion("Cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<String> values) {
            addCriterion("Cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(String value1, String value2) {
            addCriterion("Cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(String value1, String value2) {
            addCriterion("Cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andEnameIsNull() {
            addCriterion("Ename is null");
            return (Criteria) this;
        }

        public Criteria andEnameIsNotNull() {
            addCriterion("Ename is not null");
            return (Criteria) this;
        }

        public Criteria andEnameEqualTo(String value) {
            addCriterion("Ename =", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameNotEqualTo(String value) {
            addCriterion("Ename <>", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameGreaterThan(String value) {
            addCriterion("Ename >", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameGreaterThanOrEqualTo(String value) {
            addCriterion("Ename >=", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameLessThan(String value) {
            addCriterion("Ename <", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameLessThanOrEqualTo(String value) {
            addCriterion("Ename <=", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameLike(String value) {
            addCriterion("Ename like", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameNotLike(String value) {
            addCriterion("Ename not like", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameIn(List<String> values) {
            addCriterion("Ename in", values, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameNotIn(List<String> values) {
            addCriterion("Ename not in", values, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameBetween(String value1, String value2) {
            addCriterion("Ename between", value1, value2, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameNotBetween(String value1, String value2) {
            addCriterion("Ename not between", value1, value2, "ename");
            return (Criteria) this;
        }

        public Criteria andEinfoIsNull() {
            addCriterion("Einfo is null");
            return (Criteria) this;
        }

        public Criteria andEinfoIsNotNull() {
            addCriterion("Einfo is not null");
            return (Criteria) this;
        }

        public Criteria andEinfoEqualTo(String value) {
            addCriterion("Einfo =", value, "einfo");
            return (Criteria) this;
        }

        public Criteria andEinfoNotEqualTo(String value) {
            addCriterion("Einfo <>", value, "einfo");
            return (Criteria) this;
        }

        public Criteria andEinfoGreaterThan(String value) {
            addCriterion("Einfo >", value, "einfo");
            return (Criteria) this;
        }

        public Criteria andEinfoGreaterThanOrEqualTo(String value) {
            addCriterion("Einfo >=", value, "einfo");
            return (Criteria) this;
        }

        public Criteria andEinfoLessThan(String value) {
            addCriterion("Einfo <", value, "einfo");
            return (Criteria) this;
        }

        public Criteria andEinfoLessThanOrEqualTo(String value) {
            addCriterion("Einfo <=", value, "einfo");
            return (Criteria) this;
        }

        public Criteria andEinfoLike(String value) {
            addCriterion("Einfo like", value, "einfo");
            return (Criteria) this;
        }

        public Criteria andEinfoNotLike(String value) {
            addCriterion("Einfo not like", value, "einfo");
            return (Criteria) this;
        }

        public Criteria andEinfoIn(List<String> values) {
            addCriterion("Einfo in", values, "einfo");
            return (Criteria) this;
        }

        public Criteria andEinfoNotIn(List<String> values) {
            addCriterion("Einfo not in", values, "einfo");
            return (Criteria) this;
        }

        public Criteria andEinfoBetween(String value1, String value2) {
            addCriterion("Einfo between", value1, value2, "einfo");
            return (Criteria) this;
        }

        public Criteria andEinfoNotBetween(String value1, String value2) {
            addCriterion("Einfo not between", value1, value2, "einfo");
            return (Criteria) this;
        }

        public Criteria andEresultIsNull() {
            addCriterion("Eresult is null");
            return (Criteria) this;
        }

        public Criteria andEresultIsNotNull() {
            addCriterion("Eresult is not null");
            return (Criteria) this;
        }

        public Criteria andEresultEqualTo(String value) {
            addCriterion("Eresult =", value, "eresult");
            return (Criteria) this;
        }

        public Criteria andEresultNotEqualTo(String value) {
            addCriterion("Eresult <>", value, "eresult");
            return (Criteria) this;
        }

        public Criteria andEresultGreaterThan(String value) {
            addCriterion("Eresult >", value, "eresult");
            return (Criteria) this;
        }

        public Criteria andEresultGreaterThanOrEqualTo(String value) {
            addCriterion("Eresult >=", value, "eresult");
            return (Criteria) this;
        }

        public Criteria andEresultLessThan(String value) {
            addCriterion("Eresult <", value, "eresult");
            return (Criteria) this;
        }

        public Criteria andEresultLessThanOrEqualTo(String value) {
            addCriterion("Eresult <=", value, "eresult");
            return (Criteria) this;
        }

        public Criteria andEresultLike(String value) {
            addCriterion("Eresult like", value, "eresult");
            return (Criteria) this;
        }

        public Criteria andEresultNotLike(String value) {
            addCriterion("Eresult not like", value, "eresult");
            return (Criteria) this;
        }

        public Criteria andEresultIn(List<String> values) {
            addCriterion("Eresult in", values, "eresult");
            return (Criteria) this;
        }

        public Criteria andEresultNotIn(List<String> values) {
            addCriterion("Eresult not in", values, "eresult");
            return (Criteria) this;
        }

        public Criteria andEresultBetween(String value1, String value2) {
            addCriterion("Eresult between", value1, value2, "eresult");
            return (Criteria) this;
        }

        public Criteria andEresultNotBetween(String value1, String value2) {
            addCriterion("Eresult not between", value1, value2, "eresult");
            return (Criteria) this;
        }

        public Criteria andEanswerIsNull() {
            addCriterion("Eanswer is null");
            return (Criteria) this;
        }

        public Criteria andEanswerIsNotNull() {
            addCriterion("Eanswer is not null");
            return (Criteria) this;
        }

        public Criteria andEanswerEqualTo(String value) {
            addCriterion("Eanswer =", value, "eanswer");
            return (Criteria) this;
        }

        public Criteria andEanswerNotEqualTo(String value) {
            addCriterion("Eanswer <>", value, "eanswer");
            return (Criteria) this;
        }

        public Criteria andEanswerGreaterThan(String value) {
            addCriterion("Eanswer >", value, "eanswer");
            return (Criteria) this;
        }

        public Criteria andEanswerGreaterThanOrEqualTo(String value) {
            addCriterion("Eanswer >=", value, "eanswer");
            return (Criteria) this;
        }

        public Criteria andEanswerLessThan(String value) {
            addCriterion("Eanswer <", value, "eanswer");
            return (Criteria) this;
        }

        public Criteria andEanswerLessThanOrEqualTo(String value) {
            addCriterion("Eanswer <=", value, "eanswer");
            return (Criteria) this;
        }

        public Criteria andEanswerLike(String value) {
            addCriterion("Eanswer like", value, "eanswer");
            return (Criteria) this;
        }

        public Criteria andEanswerNotLike(String value) {
            addCriterion("Eanswer not like", value, "eanswer");
            return (Criteria) this;
        }

        public Criteria andEanswerIn(List<String> values) {
            addCriterion("Eanswer in", values, "eanswer");
            return (Criteria) this;
        }

        public Criteria andEanswerNotIn(List<String> values) {
            addCriterion("Eanswer not in", values, "eanswer");
            return (Criteria) this;
        }

        public Criteria andEanswerBetween(String value1, String value2) {
            addCriterion("Eanswer between", value1, value2, "eanswer");
            return (Criteria) this;
        }

        public Criteria andEanswerNotBetween(String value1, String value2) {
            addCriterion("Eanswer not between", value1, value2, "eanswer");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table exercise
     *
     * @mbg.generated do_not_delete_during_merge Sat Sep 05 21:58:25 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table exercise
     *
     * @mbg.generated Sat Sep 05 21:58:25 CST 2020
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}