class Diamond {
    private int height;

    Diamond(int height) {
        if (height % 2 == 1) this.height = height;
        else throw new java.lang.Error("Wrong diamond height. Must be positive odd number.");
    }

    String draw() {
        String result = "";
        int center = (this.height + 1) / 2;
        for (int line=1; line <= this.height; line++) result += getLine(center, line);
        return result;
    }

    private String getLine(int center, int line) {
        if (line == 1 || line == this.height) return getFirstLastLine(center);
        return getOtherLine(center, line);
    }

    private String getOtherLine(int center, int line) {
        int space_before = Math.abs(center - line);
        int spaces_between = this.height - space_before * 2 - 2;
        return repeat(" ", space_before) + "o" +
                repeat(" ", spaces_between) +
                "o" + repeat(" ", space_before) + "\n";
    }

    private String getFirstLastLine(int center) {
        return repeat(" ", center - 1) + "o" + repeat(" ", center - 1) + "\n";
    }

    private String repeat(String str, int count){
        String result = "";
        for (int i=1; i <= count; i++) result += str;
        return result;
    }
}
