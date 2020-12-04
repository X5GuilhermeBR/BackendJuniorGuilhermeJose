package br.com.employee.system.api.domain.pojos;

public class BasePojo {
    private  Object pojo;
    private int status;

    public Object getPojo() {
        return pojo;
    }

    public void setPojo(Object pojo) {
        this.pojo = pojo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(final int status) {
        this.status = status;
    }

    public void created() {
        this.status = 201;
    }

    public void ok() {
        this.status = 200;
    }

    public void badRequest() {
        this.status = 400;
    }

    public void notFound() { this.status = 404; }

    public void noContent() {
        this.status = 204001;
    }

}
