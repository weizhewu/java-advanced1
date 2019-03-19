package com.soft1841.list;
class NBA {
    private String name;
    private String nickname;
    private Double score;
    private Double backboard;
    private Double zhugong;

    public NBA(String name, String nickname, Double score, Double backboard, Double zhugong) {
        this.name = name;
        this.nickname = nickname;
        this.score = score;
        this.backboard = backboard;
        this.zhugong = zhugong;
    }

    public NBA(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Double getRebound() {
        return backboard;
    }

    public void setRebound(Double rebound) {
        this.backboard = rebound;
    }

    public Double getAssist() {
        return zhugong;
    }

    public void setAssist(Double assist) {
        this.zhugong = assist;
    }

    @Override
    public String toString() {
        return "NBA{" +
                "name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", score=" + score +
                ", rebound=" + backboard +
                ", assist=" + zhugong +
                '}';
    }
}
