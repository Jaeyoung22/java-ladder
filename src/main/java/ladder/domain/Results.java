package ladder.domain;

import java.util.Map;

import static ladder.util.NotNullValidator.validateNotNull;

public class Results {
    private final Map<PlayerName, Reward> results;

    public Results(Map<PlayerName, Reward> results) {
        validateNotNull(results);
        validateSize(results);
        this.results = results;
    }

    private void validateSize(Map<PlayerName, Reward> results) {
        if (results.size() != Players.NUM_OF_PLAYERS) {
            throw new IllegalArgumentException("사다리 게임 결과 수는 플레이어 수와 일치해야합니다.");
        }
    }

    public Reward getRewardOf(PlayerName name) {
        if (results.containsKey(name)) {
            return results.get(name);
        }
        throw new IllegalArgumentException("존재하지 않는 플레이어 이름입니다.");
    }

    public Map<PlayerName, Reward> getResults() {
        return results;
    }
}