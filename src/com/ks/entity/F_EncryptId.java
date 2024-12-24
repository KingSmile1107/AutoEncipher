package com.ks.entity;

public class F_EncryptId {
    double S, V, T, W_S, W_V, W_T;

    public F_EncryptId(double s, double v, double t, double w_S, double w_V, double w_T) {
        S = s;
        V = v;
        T = t;
        W_S = w_S;
        W_V = w_V;
        W_T = w_T;
    }

    public double getS() {
        return S;
    }

    public void setS(double s) {
        S = s;
    }

    public double getV() {
        return V;
    }

    public void setV(double v) {
        V = v;
    }

    public double getT() {
        return T;
    }

    public void setT(double t) {
        T = t;
    }

    public double getW_S() {
        return W_S;
    }

    public void setW_S(double w_S) {
        W_S = w_S;
    }

    public double getW_V() {
        return W_V;
    }

    public void setW_V(double w_V) {
        W_V = w_V;
    }

    public double getW_T() {
        return W_T;
    }

    public void setW_T(double w_T) {
        W_T = w_T;
    }

    @Override
    public String toString() {
        return "F_EncryptId{" +
                "S=" + S +
                ", V=" + V +
                ", T=" + T +
                ", W_S=" + W_S +
                ", W_V=" + W_V +
                ", W_T=" + W_T +
                '}';
    }
}
