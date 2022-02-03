package com.example.issuemanagement.util;


import com.example.issuemanagement.dto.IssueDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class TPage<T> implements Page<IssueDto> {

    private int number;     //kaçıncı sayfa
    private int size;       //kayıtları kaçarlı görmek istiyor
    private Sort sort;      //herhangi bir kolona tıklayıp onu sıralıyor
    private int totalPages; //toplamda kaç sayfa oluştu
    private Long totalElements; //toplamda kaç kayıt oluştu
    private List<T> content;    //döneceğim data gösterilecek


    public void setStat(Page page, List<T> list){

        this.number = page.getNumber();
        this.size=page.getSize();
        this.sort=page.getSort();
        this.totalPages=page.getTotalPages();
        this.totalElements = page.getTotalElements();
    }

    @Override
    public int getTotalPages() {
        return 0;
    }

    @Override
    public long getTotalElements() {
        return 0;
    }

    @Override
    public int getNumber() {
        return 0;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public int getNumberOfElements() {
        return 0;
    }

    @Override
    public List<IssueDto> getContent() {
        return null;
    }

    @Override
    public boolean hasContent() {
        return false;
    }

    @Override
    public Sort getSort() {
        return null;
    }

    @Override
    public boolean isFirst() {
        return false;
    }

    @Override
    public boolean isLast() {
        return false;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public Pageable nextPageable() {
        return null;
    }

    @Override
    public Pageable previousPageable() {
        return null;
    }

    @Override
    public <U> Page<U> map(Function<? super IssueDto, ? extends U> converter) {
        return null;
    }

    @Override
    public Iterator<IssueDto> iterator() {
        return null;
    }
}
