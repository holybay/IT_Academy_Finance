package by.it_academy.jd2.finance.user_service.service.dto;

import java.util.Objects;

public class PageDto {

    private int page;
    private int size;

    private PageDto(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public static PageDtoBuilder builder() {
        return new PageDtoBuilder();
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageDto pageDto = (PageDto) o;
        return page == pageDto.page && size == pageDto.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(page, size);
    }

    @Override
    public String toString() {
        return "PageDto{" +
                "page=" + page +
                ", size=" + size +
                '}';
    }

    public static class PageDtoBuilder {
        private int page;
        private int size;

        private PageDtoBuilder() {
        }

        public PageDto build() {
            return new PageDto(page, size);
        }

        public PageDtoBuilder setPage(int page) {
            this.page = page;
            return this;
        }

        public PageDtoBuilder setSize(int size) {
            this.size = size;
            return this;
        }
    }
}
