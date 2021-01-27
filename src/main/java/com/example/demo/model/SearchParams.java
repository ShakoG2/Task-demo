//package com.example.demo.model;
//
//import lombok.Data;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//
//@Data
//public abstract class SearchParams {
//
//    private Integer page;
//    private Integer pageSize;
//
//    public int getPage() {
//        return page == null ? 1 : page;
//    }
//
//    public int getPageSize() {
//        if (pageSize == null || pageSize == 0) {
//            return 10;
//        }
//        return pageSize;
//    }
//
//    public PageRequest toPageRequest(Sort sort) {
//        return PageRequest.of(getPage() - 1, getPageSize(), sort);
//    }
//}
