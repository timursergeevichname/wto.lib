package wto.lib.entity.statistic;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "statistics")
public class Statistics {

    @XmlAttribute
    private int tankId;

    @XmlAttribute
    private int runDistance;

    @XmlAttribute
    private int crrp;

    @XmlAttribute
    private boolean htc;

    @XmlAttribute
    private int old;

    @XmlAttribute
    private float mel;

    @XmlAttribute
    private float mrrv;

    @XmlAttribute
    private int mrmbn;

    @XmlAttribute
    private int mr;

    @XmlAttribute
    private int mrbn;

    @XmlAttribute
    private int damageCount;

    @XmlAttribute
    private int deathCount;

    @XmlAttribute
    private int killCount;

    @XmlAttribute
    private int experienceCount;

    @XmlAttribute
    private int hitCount;

    @XmlAttribute
    private int shotCount;

    @XmlAttribute
    private int winCount;

    @XmlAttribute
    private int gamesCount;


    public int getCrrp() {
        return crrp;
    }

    public boolean isHtc() {
        return htc;
    }

    public int getOld() {
        return old;
    }

    public int getShotCount() {
        return shotCount;
    }

    public int getWinCount() {
        return winCount;
    }

    public int getGamesCount() {
        return gamesCount;
    }

    public int getMr() {
        return mr;
    }

    public int getMrbn() {
        return mrbn;
    }

    public int getDamageCount() {
        return damageCount;
    }

    public int getDeathCount() {
        return deathCount;
    }

    public int getKillCount() {
        return killCount;
    }

    public int getExperienceCount() {
        return experienceCount;
    }

    public int getHitCount() {
        return hitCount;
    }

    public float getMel() {
        return mel;
    }

    public float getMrrv() {
        return mrrv;
    }

    public int getMrmbn() {
        return mrmbn;
    }

    public int getRunDistance() {
        return runDistance;
    }

    public int getTankId() {
        return tankId;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "tankId=" + tankId +
                ", runDistance=" + runDistance +
                ", crrp=" + crrp +
                ", htc=" + htc +
                ", old=" + old +
                ", mel=" + mel +
                ", mrrv=" + mrrv +
                ", mrmbn=" + mrmbn +
                ", mr=" + mr +
                ", mrbn=" + mrbn +
                ", damageCount=" + damageCount +
                ", deathCount=" + deathCount +
                ", killCount=" + killCount +
                ", experienceCount=" + experienceCount +
                ", hitCount=" + hitCount +
                ", shotCount=" + shotCount +
                ", winCount=" + winCount +
                ", gamesCount=" + gamesCount +
                '}';
    }

}
