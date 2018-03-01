package com.example.mvopo.dohba.Model;

/**
 * Created by mvopo on 2/28/2018.
 */

public class Player {
    private String id, name, jersey, position;
    private int offReb, defReb, assist, steal, block, turnOver,
            a2pts, a3pts, aFThrow, p2pts, p3pts, pFThrow;

    public Player(String id, String name, String jersey, String position) {
        this.id = id;
        this.name = name;
        this.jersey = jersey;
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getJersey() {
        return jersey;
    }

    public String getPosition() {
        return position;
    }

    public int getOffReb() {

        return offReb;
    }

    public void setOffReb(int offReb) {
        this.offReb = offReb;
    }

    public int getDefReb() {
        return defReb;
    }

    public void setDefReb(int defReb) {
        this.defReb = defReb;
    }

    public int getAssist() {
        return assist;
    }

    public void setAssist(int assist) {
        this.assist = assist;
    }

    public int getSteal() {
        return steal;
    }

    public void setSteal(int steal) {
        this.steal = steal;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getTurnOver() {
        return turnOver;
    }

    public void setTurnOver(int turnOver) {
        this.turnOver = turnOver;
    }

    public int getA2pts() {
        return a2pts;
    }

    public void setA2pts(int a2pts) {
        this.a2pts = a2pts;
    }

    public int getA3pts() {
        return a3pts;
    }

    public void setA3pts(int a3pts) {
        this.a3pts = a3pts;
    }

    public int getaFThrow() {
        return aFThrow;
    }

    public void setaFThrow(int aFThrow) {
        this.aFThrow = aFThrow;
    }

    public int getP2pts() {
        return p2pts;
    }

    public void setP2pts(int p2pts) {
        this.p2pts = p2pts;
    }

    public int getP3pts() {
        return p3pts;
    }

    public void setP3pts(int p3pts) {
        this.p3pts = p3pts;
    }

    public int getpFThrow() {
        return pFThrow;
    }

    public void setpFThrow(int pFThrow) {
        this.pFThrow = pFThrow;
    }
}
