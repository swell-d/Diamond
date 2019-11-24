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
        for (int line=1; line <= this.height; line++) result += line(line);
        return result;
    }

    private String line(int line) {
        return isOuter(line)? outerLine() : innerLine(line);
    }

    private boolean isOuter(int line) {
        return line == 1 || line == this.height;
    }

    private String innerLine(int line) {
        int outerSpaces = Math.abs(this.center - line);
        int spacesBetween = this.height - outerSpaces * 2 - 2;
        return repeat(" ", outerSpaces) + "o" +
                repeat(" ", spacesBetween) +
                "o" + repeat(" ", outerSpaces) + "\n";
    }

    private String outerLine() {
        return repeat(" ", this.center - 1) + "o" + repeat(" ", this.center - 1) + "\n";
    }

    private String repeat(String str, int count){
        String result = "";
        for (int i=1; i <= count; i++) result += str;
        return result;
    }
}
