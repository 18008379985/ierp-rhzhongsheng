package com.soa.ierp.client;

public class OrderAmount {

    private double fwf_by=0.00;//服务费_本月累计；
    private double fwf_bn=0.00;//服务费_本年累计；

    private double fwf_yhk_by=0.00;//服务费_已回款_本月累计；
    private double fwf_yhk_bn=0.00;//服务费_已回款_本年累计；

    private double fwf_tc_by=0.00;//服务费_提成_本月累计；
    private double fwf_tc_bn=0.00;//服务费_提成_本年累计；

    public double getFwf_by() {
        return fwf_by;
    }

    public void setFwf_by(double fwf_by) {
        this.fwf_by = fwf_by;
    }

    public double getFwf_bn() {
        return fwf_bn;
    }

    public void setFwf_bn(double fwf_bn) {
        this.fwf_bn = fwf_bn;
    }

    public double getFwf_yhk_by() {
        return fwf_yhk_by;
    }

    public void setFwf_yhk_by(double fwf_yhk_by) {
        this.fwf_yhk_by = fwf_yhk_by;
    }

    public double getFwf_yhk_bn() {
        return fwf_yhk_bn;
    }

    public void setFwf_yhk_bn(double fwf_yhk_bn) {
        this.fwf_yhk_bn = fwf_yhk_bn;
    }

    public double getFwf_tc_by() {
        return fwf_tc_by;
    }

    public void setFwf_tc_by(double fwf_tc_by) {
        this.fwf_tc_by = fwf_tc_by;
    }

    public double getFwf_tc_bn() {
        return fwf_tc_bn;
    }

    public void setFwf_tc_bn(double fwf_tc_bn) {
        this.fwf_tc_bn = fwf_tc_bn;
    }
}
