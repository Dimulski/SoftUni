package Problem6FootballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class FootballTeamGenerator {

    private static HashMap<String, Team> teams;
    public static void main(String[] args) throws IOException {

        teams = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        try {
            while (!(line = reader.readLine()).equals("END")) {
                String[] lineParams = line.split(";");
                switch (lineParams[0]) {
                    case "Team":
                        Team team = new Team(lineParams[1]);
                        teams.put(team.getName(), team);
                        break;
                    case "Add":
                        try {
                            tryAddPlayer(lineParams);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "Remove":
                        try {
                            tryRemovePlayer(lineParams);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "Rating":
                        try {
                            System.out.println(String.format("%s - %d", lineParams[1], Math.round(teams.get(lineParams[1]).calcRating())));
                        } catch (NullPointerException e) {
                            System.out.println(String.format(ExceptionMessages.NON_EXISTENT_TEAM, lineParams[1]));
                        }
                        break;
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void tryRemovePlayer(String[] lineParams) {
        if (!teams.containsKey(lineParams[1])) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NON_EXISTENT_TEAM, lineParams[1]));
        }

        teams.get(lineParams[1]).removePlayer(lineParams[2]);
    }

    private static void tryAddPlayer(String[] lineParams) {
        if (!teams.containsKey(lineParams[1])) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NON_EXISTENT_TEAM, lineParams[1]));
        }

        Player player = new Player(lineParams[2], Integer.parseInt(lineParams[3]), Integer.parseInt(lineParams[4]), Integer.parseInt(lineParams[5]), Integer.parseInt(lineParams[6]), Integer.parseInt(lineParams[7]));
        teams.get(lineParams[1]).addPlayer(player);
    }

    private static class Team {
        private String name;
        private HashMap<String, Player> players;

        Team(String name) {
            this.setName(name);
            this.setPlayers();
        }

        String getName() {
            return this.name;
        }

        Double calcRating() {
            Double result = 0d;
            for (Player player : getPlayers().values()) {
                result += player.calcSkillLevel();
            }
            return result / getPlayers().size();
        }

        void addPlayer(Player player) {
            this.players.put(player.getName(), player);
        }

        void removePlayer(String playerName) {
            if (!getPlayers().containsKey(playerName)) {
                throw new IllegalArgumentException(String.format(ExceptionMessages.MISSING_PLAYER, playerName, getName()));
            }

            getPlayers().remove(playerName);
        }

        private void setName(String name) {
            if (name == null || name.length() == 0) {
                throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME);
            }

            this.name = name;
        }

        private HashMap<String, Player> getPlayers() {
            return this.players;
        }

        private void setPlayers() {
            this.players = new HashMap<>();
        }
    }

    private static class Player {
        private static final Integer STAT_LOWER_LIMIT;
        private static final Integer STAT_UPPER_LIMIT;
        private String name;
        private Integer endurance;
        private Integer sprint;
        private Integer dribble;
        private Integer passing;
        private Integer shooting;

        static {
            STAT_LOWER_LIMIT = 0;
            STAT_UPPER_LIMIT = 100;
        }

        Player(String name, Integer endurance, Integer sprint, Integer dribble, Integer passing, Integer shooting) {
            this.setName(name);
            this.setEndurance(endurance);
            this.setSprint(sprint);
            this.setDribble(dribble);
            this.setPassing(passing);
            this.setShooting(shooting);
        }

        String getName() {
            return this.name;
        }

        Double calcSkillLevel() {
            return (double) (getEndurance() + getSprint() + getDribble() + getPassing() + getShooting()) / 5;
        }

        private void setName(String name) {
            if (name == null || name.length() == 0) {
                throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME);
            }

            this.name = name;
        }

        private Integer getEndurance() {
            return this.endurance;
        }

        private void setEndurance(Integer endurance) {
            if (endurance < STAT_LOWER_LIMIT || endurance > STAT_UPPER_LIMIT) {
                throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_STAT_VALUE,
                        "Endurance", STAT_LOWER_LIMIT, STAT_UPPER_LIMIT));
            }

            this.endurance = endurance;
        }

        private Integer getSprint() {
            return this.sprint;
        }

        private void setSprint(Integer sprint) {
            if (sprint < STAT_LOWER_LIMIT || sprint > STAT_UPPER_LIMIT) {
                throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_STAT_VALUE,
                        "Sprint", STAT_LOWER_LIMIT, STAT_UPPER_LIMIT));
            }

            this.sprint = sprint;
        }

        private Integer getDribble() {
            return this.dribble;
        }

        private void setDribble(Integer dribble) {
            if (dribble < STAT_LOWER_LIMIT || dribble > STAT_UPPER_LIMIT) {
                throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_STAT_VALUE,
                        "Dribble", STAT_LOWER_LIMIT, STAT_UPPER_LIMIT));
            }

            this.dribble = dribble;
        }

        private Integer getPassing() {
            return this.passing;
        }

        private void setPassing(Integer passing) {
            if (passing < STAT_LOWER_LIMIT || passing > STAT_UPPER_LIMIT) {
                throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_STAT_VALUE,
                        "Passing", STAT_LOWER_LIMIT, STAT_UPPER_LIMIT));
            }

            this.passing = passing;
        }

        private Integer getShooting() {
            return this.shooting;
        }

        private void setShooting(Integer shooting) {
            if (shooting < STAT_LOWER_LIMIT || shooting > STAT_UPPER_LIMIT) {
                throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_STAT_VALUE,
                        "Shooting", STAT_LOWER_LIMIT, STAT_UPPER_LIMIT));
            }

            this.shooting = shooting;
        }
    }

    private class ExceptionMessages {
        static final String INVALID_NAME = "A name should not be empty.";
        static final String INVALID_STAT_VALUE = "%s should be between %d and %d.";
        static final String MISSING_PLAYER = "Player %s is not in %s team.";
        static final String NON_EXISTENT_TEAM = "Team %s does not exist.";
    }
}
