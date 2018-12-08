package com.chwangteng.www.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MotificationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MotificationExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdMoIsNull() {
            addCriterion("user_id_mo is null");
            return (Criteria) this;
        }

        public Criteria andUserIdMoIsNotNull() {
            addCriterion("user_id_mo is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdMoEqualTo(Integer value) {
            addCriterion("user_id_mo =", value, "userIdMo");
            return (Criteria) this;
        }

        public Criteria andUserIdMoNotEqualTo(Integer value) {
            addCriterion("user_id_mo <>", value, "userIdMo");
            return (Criteria) this;
        }

        public Criteria andUserIdMoGreaterThan(Integer value) {
            addCriterion("user_id_mo >", value, "userIdMo");
            return (Criteria) this;
        }

        public Criteria andUserIdMoGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id_mo >=", value, "userIdMo");
            return (Criteria) this;
        }

        public Criteria andUserIdMoLessThan(Integer value) {
            addCriterion("user_id_mo <", value, "userIdMo");
            return (Criteria) this;
        }

        public Criteria andUserIdMoLessThanOrEqualTo(Integer value) {
            addCriterion("user_id_mo <=", value, "userIdMo");
            return (Criteria) this;
        }

        public Criteria andUserIdMoIn(List<Integer> values) {
            addCriterion("user_id_mo in", values, "userIdMo");
            return (Criteria) this;
        }

        public Criteria andUserIdMoNotIn(List<Integer> values) {
            addCriterion("user_id_mo not in", values, "userIdMo");
            return (Criteria) this;
        }

        public Criteria andUserIdMoBetween(Integer value1, Integer value2) {
            addCriterion("user_id_mo between", value1, value2, "userIdMo");
            return (Criteria) this;
        }

        public Criteria andUserIdMoNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id_mo not between", value1, value2, "userIdMo");
            return (Criteria) this;
        }

        public Criteria andUserTypeMoIsNull() {
            addCriterion("user_type_mo is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeMoIsNotNull() {
            addCriterion("user_type_mo is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeMoEqualTo(Integer value) {
            addCriterion("user_type_mo =", value, "userTypeMo");
            return (Criteria) this;
        }

        public Criteria andUserTypeMoNotEqualTo(Integer value) {
            addCriterion("user_type_mo <>", value, "userTypeMo");
            return (Criteria) this;
        }

        public Criteria andUserTypeMoGreaterThan(Integer value) {
            addCriterion("user_type_mo >", value, "userTypeMo");
            return (Criteria) this;
        }

        public Criteria andUserTypeMoGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_type_mo >=", value, "userTypeMo");
            return (Criteria) this;
        }

        public Criteria andUserTypeMoLessThan(Integer value) {
            addCriterion("user_type_mo <", value, "userTypeMo");
            return (Criteria) this;
        }

        public Criteria andUserTypeMoLessThanOrEqualTo(Integer value) {
            addCriterion("user_type_mo <=", value, "userTypeMo");
            return (Criteria) this;
        }

        public Criteria andUserTypeMoIn(List<Integer> values) {
            addCriterion("user_type_mo in", values, "userTypeMo");
            return (Criteria) this;
        }

        public Criteria andUserTypeMoNotIn(List<Integer> values) {
            addCriterion("user_type_mo not in", values, "userTypeMo");
            return (Criteria) this;
        }

        public Criteria andUserTypeMoBetween(Integer value1, Integer value2) {
            addCriterion("user_type_mo between", value1, value2, "userTypeMo");
            return (Criteria) this;
        }

        public Criteria andUserTypeMoNotBetween(Integer value1, Integer value2) {
            addCriterion("user_type_mo not between", value1, value2, "userTypeMo");
            return (Criteria) this;
        }

        public Criteria andGenerateTimeMoIsNull() {
            addCriterion("generate_time_mo is null");
            return (Criteria) this;
        }

        public Criteria andGenerateTimeMoIsNotNull() {
            addCriterion("generate_time_mo is not null");
            return (Criteria) this;
        }

        public Criteria andGenerateTimeMoEqualTo(Date value) {
            addCriterion("generate_time_mo =", value, "generateTimeMo");
            return (Criteria) this;
        }

        public Criteria andGenerateTimeMoNotEqualTo(Date value) {
            addCriterion("generate_time_mo <>", value, "generateTimeMo");
            return (Criteria) this;
        }

        public Criteria andGenerateTimeMoGreaterThan(Date value) {
            addCriterion("generate_time_mo >", value, "generateTimeMo");
            return (Criteria) this;
        }

        public Criteria andGenerateTimeMoGreaterThanOrEqualTo(Date value) {
            addCriterion("generate_time_mo >=", value, "generateTimeMo");
            return (Criteria) this;
        }

        public Criteria andGenerateTimeMoLessThan(Date value) {
            addCriterion("generate_time_mo <", value, "generateTimeMo");
            return (Criteria) this;
        }

        public Criteria andGenerateTimeMoLessThanOrEqualTo(Date value) {
            addCriterion("generate_time_mo <=", value, "generateTimeMo");
            return (Criteria) this;
        }

        public Criteria andGenerateTimeMoIn(List<Date> values) {
            addCriterion("generate_time_mo in", values, "generateTimeMo");
            return (Criteria) this;
        }

        public Criteria andGenerateTimeMoNotIn(List<Date> values) {
            addCriterion("generate_time_mo not in", values, "generateTimeMo");
            return (Criteria) this;
        }

        public Criteria andGenerateTimeMoBetween(Date value1, Date value2) {
            addCriterion("generate_time_mo between", value1, value2, "generateTimeMo");
            return (Criteria) this;
        }

        public Criteria andGenerateTimeMoNotBetween(Date value1, Date value2) {
            addCriterion("generate_time_mo not between", value1, value2, "generateTimeMo");
            return (Criteria) this;
        }

        public Criteria andTitleMoIsNull() {
            addCriterion("title_mo is null");
            return (Criteria) this;
        }

        public Criteria andTitleMoIsNotNull() {
            addCriterion("title_mo is not null");
            return (Criteria) this;
        }

        public Criteria andTitleMoEqualTo(String value) {
            addCriterion("title_mo =", value, "titleMo");
            return (Criteria) this;
        }

        public Criteria andTitleMoNotEqualTo(String value) {
            addCriterion("title_mo <>", value, "titleMo");
            return (Criteria) this;
        }

        public Criteria andTitleMoGreaterThan(String value) {
            addCriterion("title_mo >", value, "titleMo");
            return (Criteria) this;
        }

        public Criteria andTitleMoGreaterThanOrEqualTo(String value) {
            addCriterion("title_mo >=", value, "titleMo");
            return (Criteria) this;
        }

        public Criteria andTitleMoLessThan(String value) {
            addCriterion("title_mo <", value, "titleMo");
            return (Criteria) this;
        }

        public Criteria andTitleMoLessThanOrEqualTo(String value) {
            addCriterion("title_mo <=", value, "titleMo");
            return (Criteria) this;
        }

        public Criteria andTitleMoLike(String value) {
            addCriterion("title_mo like", value, "titleMo");
            return (Criteria) this;
        }

        public Criteria andTitleMoNotLike(String value) {
            addCriterion("title_mo not like", value, "titleMo");
            return (Criteria) this;
        }

        public Criteria andTitleMoIn(List<String> values) {
            addCriterion("title_mo in", values, "titleMo");
            return (Criteria) this;
        }

        public Criteria andTitleMoNotIn(List<String> values) {
            addCriterion("title_mo not in", values, "titleMo");
            return (Criteria) this;
        }

        public Criteria andTitleMoBetween(String value1, String value2) {
            addCriterion("title_mo between", value1, value2, "titleMo");
            return (Criteria) this;
        }

        public Criteria andTitleMoNotBetween(String value1, String value2) {
            addCriterion("title_mo not between", value1, value2, "titleMo");
            return (Criteria) this;
        }

        public Criteria andContentMoIsNull() {
            addCriterion("content_mo is null");
            return (Criteria) this;
        }

        public Criteria andContentMoIsNotNull() {
            addCriterion("content_mo is not null");
            return (Criteria) this;
        }

        public Criteria andContentMoEqualTo(String value) {
            addCriterion("content_mo =", value, "contentMo");
            return (Criteria) this;
        }

        public Criteria andContentMoNotEqualTo(String value) {
            addCriterion("content_mo <>", value, "contentMo");
            return (Criteria) this;
        }

        public Criteria andContentMoGreaterThan(String value) {
            addCriterion("content_mo >", value, "contentMo");
            return (Criteria) this;
        }

        public Criteria andContentMoGreaterThanOrEqualTo(String value) {
            addCriterion("content_mo >=", value, "contentMo");
            return (Criteria) this;
        }

        public Criteria andContentMoLessThan(String value) {
            addCriterion("content_mo <", value, "contentMo");
            return (Criteria) this;
        }

        public Criteria andContentMoLessThanOrEqualTo(String value) {
            addCriterion("content_mo <=", value, "contentMo");
            return (Criteria) this;
        }

        public Criteria andContentMoLike(String value) {
            addCriterion("content_mo like", value, "contentMo");
            return (Criteria) this;
        }

        public Criteria andContentMoNotLike(String value) {
            addCriterion("content_mo not like", value, "contentMo");
            return (Criteria) this;
        }

        public Criteria andContentMoIn(List<String> values) {
            addCriterion("content_mo in", values, "contentMo");
            return (Criteria) this;
        }

        public Criteria andContentMoNotIn(List<String> values) {
            addCriterion("content_mo not in", values, "contentMo");
            return (Criteria) this;
        }

        public Criteria andContentMoBetween(String value1, String value2) {
            addCriterion("content_mo between", value1, value2, "contentMo");
            return (Criteria) this;
        }

        public Criteria andContentMoNotBetween(String value1, String value2) {
            addCriterion("content_mo not between", value1, value2, "contentMo");
            return (Criteria) this;
        }

        public Criteria andReadMoIsNull() {
            addCriterion("read_mo is null");
            return (Criteria) this;
        }

        public Criteria andReadMoIsNotNull() {
            addCriterion("read_mo is not null");
            return (Criteria) this;
        }

        public Criteria andReadMoEqualTo(Integer value) {
            addCriterion("read_mo =", value, "readMo");
            return (Criteria) this;
        }

        public Criteria andReadMoNotEqualTo(Integer value) {
            addCriterion("read_mo <>", value, "readMo");
            return (Criteria) this;
        }

        public Criteria andReadMoGreaterThan(Integer value) {
            addCriterion("read_mo >", value, "readMo");
            return (Criteria) this;
        }

        public Criteria andReadMoGreaterThanOrEqualTo(Integer value) {
            addCriterion("read_mo >=", value, "readMo");
            return (Criteria) this;
        }

        public Criteria andReadMoLessThan(Integer value) {
            addCriterion("read_mo <", value, "readMo");
            return (Criteria) this;
        }

        public Criteria andReadMoLessThanOrEqualTo(Integer value) {
            addCriterion("read_mo <=", value, "readMo");
            return (Criteria) this;
        }

        public Criteria andReadMoIn(List<Integer> values) {
            addCriterion("read_mo in", values, "readMo");
            return (Criteria) this;
        }

        public Criteria andReadMoNotIn(List<Integer> values) {
            addCriterion("read_mo not in", values, "readMo");
            return (Criteria) this;
        }

        public Criteria andReadMoBetween(Integer value1, Integer value2) {
            addCriterion("read_mo between", value1, value2, "readMo");
            return (Criteria) this;
        }

        public Criteria andReadMoNotBetween(Integer value1, Integer value2) {
            addCriterion("read_mo not between", value1, value2, "readMo");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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