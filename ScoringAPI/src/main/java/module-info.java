import dk.sdu.cbse.common.scoring.IScoringSPI;
import dk.sdu.cbse.scoringapi.ScoringAPI;

module ScoringAPI {
    requires CommonScoring;
    requires spring.web;

    provides IScoringSPI with ScoringAPI;
}