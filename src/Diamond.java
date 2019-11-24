class Diamond {
    private int center;
    private int height;
    private final String blank = " ";

    Diamond(int height) {
        if (height % 2 != 1) throw new IllegalArgumentException("Wrong diamond height. Must be positive odd number.");
        this.height = height;
        this.center = (this.height + 1) / 2;
    }

    String draw() {
        String result = "";
        for (int line=1; line <= this.height; line++) result += drawLine(line);
        return result;
    }

    private String drawLine(int line) {
        return isOuter(line)? outerLine() : innerLine(line);
    }

    private boolean isOuter(int line) {
        return line == 1 || line == this.height;
    }

    private String innerLine(int line) {
        int outerSpaces = Math.abs(this.center - line);
        int spacesBetween = this.height - outerSpaces * 2 - 2;
        return blanks(outerSpaces) + "o" + blanks(spacesBetween) + "o" + blanks(outerSpaces) + "\n";
    }

    private String outerLine() {
        return blanks(this.center - 1) + "o" + blanks(this.center - 1) + "\n";
    }

    private String blanks(int count){
        String result = "";
        for (int i=1; i <= count; i++) result += blank;
        return result;
    }
}
