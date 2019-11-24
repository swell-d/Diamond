class Diamond {
    private int center;
    private int height;

    Diamond(int height) {
        if (height % 2 != 1) throw new IllegalArgumentException("Wrong diamond height. Must be positive odd number.");
        this.height = height;
        this.center = (this.height + 1) / 2;
    }

    String draw() {
        String result = "";
        for (int line=1; line <= this.height; line++) result += Line(line);
        return result;
    }

    private String Line(int line) {
        return isOuterLine(line)? OuterLine() : InnerLine(line);
    }

    private boolean isOuterLine(int line) {
        return line == 1 || line == this.height;
    }

    private String InnerLine(int line) {
        int spaces_before = Math.abs(this.center - line);
        int spaces_between = this.height - spaces_before * 2 - 2;
        return repeat(" ", spaces_before) + "o" +
                repeat(" ", spaces_between) +
                "o" + repeat(" ", spaces_before) + "\n";
    }

    private String OuterLine() {
        return repeat(" ", this.center - 1) + "o" + repeat(" ", this.center - 1) + "\n";
    }

    private String repeat(String str, int count){
        String result = "";
        for (int i=1; i <= count; i++) result += str;
        return result;
    }
}
