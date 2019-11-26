class Diamond {
    public static final String DRAWING_POINT = "o";
    private final String BLANK = " ";
    private int center;
    private int height;

    Diamond(int height) {
        verifyHeight(height);
        this.height = height;
        this.center = (this.height + 1) / 2;
    }

    private void verifyHeight(int height) {
        if (height % 2 != 1) throw new IllegalArgumentException(
                "Wrong diamond height. Must be positive odd number.");
    }

    String draw() {
        String result = "";
        for (int line = 1; line <= this.height; line++) result += draw(line);
        return result;
    }

    private String draw(int line) {
        return isOuter(line) ?
                drawOuterLine() :
                drawInner(line);
    }

    private boolean isOuter(int line) {
        return line == 1 || line == this.height;
    }

    private String drawInner(int line) {
        int outerSpaces = Math.abs(this.center - line);
        int spacesBetween = this.height - outerSpaces * 2 - 2;
        return blanks(outerSpaces) + DRAWING_POINT + blanks(spacesBetween) + DRAWING_POINT + blanks(outerSpaces) + "\n";
    }

    private String drawOuterLine() {
        return blanks(this.center - 1) + DRAWING_POINT + blanks(this.center - 1) + "\n";
    }

    private String blanks(int count) {
        String result = "";
        for (int i = 1; i <= count; i++) result += BLANK;
        return result;
    }
}
