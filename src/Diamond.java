class Diamond {
    private int height;

    Diamond(int height) {
        if (height % 2 != 1) throw new IllegalArgumentException("Wrong diamond height. Must be positive odd number.");
        this.height = height;
    }

    String draw() {
        String result = "";
        int center = (this.height + 1) / 2;
        for (int line=1; line <= this.height; line++) result += Line(center, line);
        return result;
    }

    private String Line(int center, int line) {
        return isOuterLine(line)? OuterLine(center) : InnerLine(center, line);
    }

    private boolean isOuterLine(int line) {
        return line == 1 || line == this.height;
    }

    private String InnerLine(int center, int line) {
        int spaces_before = Math.abs(center - line);
        int spaces_between = this.height - spaces_before * 2 - 2;
        return repeat(" ", spaces_before) + "o" +
                repeat(" ", spaces_between) +
                "o" + repeat(" ", spaces_before) + "\n";
    }

    private String OuterLine(int center) {
        return repeat(" ", center - 1) + "o" + repeat(" ", center - 1) + "\n";
    }

    private String repeat(String str, int count){
        String result = "";
        for (int i=1; i <= count; i++) result += str;
        return result;
    }
}
