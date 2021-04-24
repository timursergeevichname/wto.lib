package wto.lib.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "client-profile-response")
public class ClientProfileResponse {

    @XmlAttribute
    private boolean isOnline;

    @XmlAttribute
    private boolean isInFleet;

    @XmlAttribute
    private boolean isInIgnore;

    @XmlAttribute
    private boolean isBan;

    @XmlAttribute
    private boolean isModerator;

    @XmlAttribute
    private boolean isFriends;

    @XmlAttribute
    private int level;

    @XmlElement
    private Statistic statistic;

    public Statistic getStatistic() {
        return statistic;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public boolean isInFleet() {
        return isInFleet;
    }

    public boolean isInIgnore() {
        return isInIgnore;
    }

    public boolean isBan() {
        return isBan;
    }

    public boolean isModerator() {
        return isModerator;
    }

    public boolean isFriends() {
        return isFriends;
    }

    public int getLevel() {
        return level;
    }


    @Override
    public String toString() {
        return "ClientProfileResponse{" +
                "isOnline=" + isOnline +
                ", isInFleet=" + isInFleet +
                ", isInIgnore=" + isInIgnore +
                ", isBan=" + isBan +
                ", isModerator=" + isModerator +
                ", isFriends=" + isFriends +
                ", level=" + level +
                ", statistic=" + statistic +
                '}';
    }

    @XmlRootElement(name = "statistic")
    public static class Statistic {

        @XmlAttribute(name = "max_experience")
        private int maxExperience;

        @XmlAttribute(name = "max_damage")
        private int maxDamage;

        @XmlAttribute
        private int damage;

        @XmlAttribute(name = "max_frags_pvp")
        private int maxFragPVP;

        @XmlAttribute(name = "money_pvp")
        private int moneyPVP;

        @XmlAttribute(name = "died_pvp")
        private int diedPVP;

        @XmlAttribute(name = "frags_pvp")
        private int fragsPVP;

        @XmlAttribute(name = "money_pve")
        private int moneyPVE;

        @XmlAttribute(name = "died_pve")
        private int diedPVE;

        @XmlAttribute(name = "frags_pve")
        private int fragsPVE;

        @XmlAttribute
        private int quests;

        @XmlAttribute(name = "lose_maps")
        private int loseMaps;

        @XmlAttribute(name = "win_maps")
        private int winMaps;

        @XmlAttribute
        private int level;

        @XmlAttribute(name = "experience-next")
        private int experienceNext;

        @XmlAttribute
        private int experience;

        public int getMaxExperience() {
            return maxExperience;
        }

        public int getMaxDamage() {
            return maxDamage;
        }

        public int getDamage() {
            return damage;
        }

        public int getMaxFragPVP() {
            return maxFragPVP;
        }

        public int getLevel() {
            return level;
        }

        public int getMoneyPVP() {
            return moneyPVP;
        }

        public int getDiedPVP() {
            return diedPVP;
        }

        public int getFragsPVP() {
            return fragsPVP;
        }

        public int getMoneyPVE() {
            return moneyPVE;
        }

        public int getDiedPVE() {
            return diedPVE;
        }

        public int getFragsPVE() {
            return fragsPVE;
        }

        public int getQuests() {
            return quests;
        }

        public int getLoseMaps() {
            return loseMaps;
        }

        public int getExperienceNext() {
            return experienceNext;
        }

        public int getExperience() {
            return experience;
        }

        public int getWinMaps() {
            return winMaps;
        }

        @Override
        public String toString() {
            return "Statistic{" +
                    "maxExperience=" + maxExperience +
                    ", maxDamage=" + maxDamage +
                    ", damage=" + damage +
                    ", maxFragPVP=" + maxFragPVP +
                    ", moneyPVP=" + moneyPVP +
                    ", diedPVP=" + diedPVP +
                    ", fragsPVP=" + fragsPVP +
                    ", moneyPVE=" + moneyPVE +
                    ", diedPVE=" + diedPVE +
                    ", fragsPVE=" + fragsPVE +
                    ", quests=" + quests +
                    ", loseMaps=" + loseMaps +
                    ", winMaps=" + winMaps +
                    ", level=" + level +
                    ", experienceNext=" + experienceNext +
                    ", experience=" + experience +
                    '}';
        }

    }
}
