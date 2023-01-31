package pl.pa.family.create.app.domain;

enum FamilyMemberType {

    INFANT(0, 4),
    CHILD(5, 16),
    ADULT(17, Integer.MAX_VALUE);

    private int minAge;
    private int maxAge;

    FamilyMemberType(int minAge, int maxAge) {
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    static boolean isInfant(int age) {
        return (age >= INFANT.minAge && age <= INFANT.maxAge);
    }
    static boolean isChild(int age) {
        return (age >= CHILD.minAge && age <= CHILD.maxAge);
    }
    static boolean idAdult(int age) {
        return (age >= ADULT.minAge && age <= ADULT.maxAge);
    }
}
