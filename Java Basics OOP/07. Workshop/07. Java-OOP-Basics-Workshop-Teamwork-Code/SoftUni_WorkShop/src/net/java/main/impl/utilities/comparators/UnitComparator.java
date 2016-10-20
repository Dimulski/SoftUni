package net.java.main.impl.utilities.comparators;

import net.java.main.impl.utilities.models.units.Unit;

import java.util.Comparator;

public enum UnitComparator implements Comparator<Unit> {
    HEALTH_POINTS {
        public int compare(Unit unit1, Unit unit2) {
            return Integer.valueOf(unit1.getHealthPoints()).compareTo(unit2.getHealthPoints());
        }},
    NAME {
        public int compare(Unit unit1, Unit unit2) {
            return unit1.getName().compareTo(unit2.getName());
        }};

    public static Comparator<Unit> getComparator(final UnitComparator... multipleOptions) {
        return new Comparator<Unit>() {
            public int compare(Unit unit1, Unit unit2) {
                for (UnitComparator option : multipleOptions) {
                    int result = option.compare(unit1, unit2);
                    if (result != 0) {
                        return result;
                    }
                }
                return 0;
            }
        };
    }
}
