package ir.sharif.math.ap2023.mafia.logic;

import ir.sharif.math.ap2023.mafia.model.*;

import java.util.*;

public class GameState {
    //--------------------------------------------------Fields--------------------------------------------------------//
    public List<Player> alivePlayers;
    public Player executed = null;
    public Player winnerJ = null;
    public int existJ = 0;
    public List<Player> winnerC = new ArrayList<>();
    public List<Player> winnerM = new ArrayList<>();
    public List<Player> deadPlayers = new ArrayList<>();
    public List<Player> deadPlayersInLastRound = new ArrayList<>();
    public Player silentPlayerInLastRound = null;
    public List<Player> players;
    public int round = 0;
    public boolean day = true;

    public GameState(List<Player> players) {
        this.players = players;
        this.alivePlayers = players;
        for (Player player : players) {
            if (player instanceof Mafia) {
                winnerM.add(player);
            } else if (player instanceof Citizen) {
                winnerC.add(player);
            } else if (player instanceof Joker) {
                winnerJ = player;
                existJ = 1;
            }
        }
    }

    //--------------------------------------------------Fields--------------------------------------------------------//
    //----------------------------------------------------getter and setter-------------------------------------------//
    public void setAlivePlayers(List<Player> alivePlayers) {
        this.alivePlayers = alivePlayers;
    }

    public Player getExecuted() {
        return executed;
    }

    public void setExecuted(Player executed) {
        this.executed = executed;
    }

    public Player getWinnerJ() {
        return winnerJ;
    }

    public void setWinnerJ(Player winnerJ) {
        this.winnerJ = winnerJ;
    }

    public int getExistJ() {
        return existJ;
    }

    public void setExistJ(int existJ) {
        this.existJ = existJ;
    }

    public List<Player> getWinnerC() {
        return winnerC;
    }

    public void setWinnerC(List<Player> winnerC) {
        this.winnerC = winnerC;
    }

    public List<Player> getWinnerM() {
        return winnerM;
    }

    public void setWinnerM(List<Player> winnerM) {
        this.winnerM = winnerM;
    }

    public List<Player> getDeadPlayers() {
        return deadPlayers;
    }

    public void setDeadPlayers(List<Player> deadPlayers) {
        this.deadPlayers = deadPlayers;
    }

    public void setDeadPlayersInLastRound(List<Player> deadPlayersInLastRound) {
        this.deadPlayersInLastRound = deadPlayersInLastRound;
    }

    public void setSilentPlayerInLastRound(Player silentPlayerInLastRound) {
        this.silentPlayerInLastRound = silentPlayerInLastRound;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public void setDay(boolean day) {
        this.day = day;
    }

    public int getRound() {
        return this.round;
    }

    public List<Player> getAlivePlayers() {
        return this.alivePlayers;
    }

    public boolean isDay() {
        return this.day;
    }

    public List<Player> getDeadPlayersInLastRound() {
        return this.deadPlayersInLastRound;
    }

    public Player getSilentPlayerInLastRound() {
        return this.silentPlayerInLastRound;
    }

    public Player getExecutedPlayer() {
        return this.executed;
    }

    //----------------------------------------------------getter and setter-------------------------------------------//
    //---------------------------------------------------methods------------------------------------------------------//
    public List<Player> allPlayers() {
        return this.players;
    }

    public void execute(List<Player> players) {
        int size = players.size();
        for (int i = 0; i < size; i++) {
            if (players.get(i).votedDay > size / 2) {
                players.get(i).isExecute = true;
            }
        }
    }

    public void kill(List<Player> players) {
        int init = 0;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).votedNight >= 1) {
                init++;
            }
        }
        if (init >= 1) {
            Player killed = players.get(0);
            for (Player player : players) {
                if (player.votedNight >= killed.votedNight) {
                    killed = player;
                }
            }
            killed.killedWithMafia = true;
        }
    }

    public void nextDay() {
        this.day = true;
        this.round++;
        kill(alivePlayers);
        for (Player alivePlayer : alivePlayers) {
            if (alivePlayer.isMute()) {
                this.silentPlayerInLastRound = alivePlayer;
            }
            if (alivePlayer.killedWithMafia && !alivePlayer.healedWithDoc) {
                this.deadPlayersInLastRound.add(alivePlayer);
                this.deadPlayers.add(alivePlayer);
                alivePlayer.setAlive(false);
                if (alivePlayer.equals(winnerJ)) {
                    existJ = 0;
                }
            }
            if (alivePlayer.healedWithDocLec || alivePlayer.healedWithDoc) {
                alivePlayer.setHeal(true);
            }
            if (alivePlayer.killedWithSniper && !alivePlayer.healedWithDocLec) {
                this.deadPlayersInLastRound.add(alivePlayer);
                this.deadPlayers.add(alivePlayer);
                alivePlayer.setAlive(false);
                if (alivePlayer.equals(winnerJ)) {
                    existJ = 0;
                }
            }
        }
        for (int i = 0; i < deadPlayersInLastRound.size(); i++) {
            inner:
            for (int j = 0; j < alivePlayers.size(); j++) {
                if (alivePlayers.get(j).equals(deadPlayersInLastRound.get(i))) {
                    alivePlayers.remove(alivePlayers.get(j));
                    break inner;
                }
            }
        }
        for (int i = 0; i < alivePlayers.size(); i++) {
            alivePlayers.get(i).votedDay = 0;
            alivePlayers.get(i).votedNight = 0;
        }
    }

    public void nextNight() {
        this.executed = null;
        execute(alivePlayers);
        this.day = false;
        this.deadPlayersInLastRound.clear();
        silentPlayerInLastRound = null;
        for (Player alivePlayer : alivePlayers) {
            if (alivePlayer.isMute()) {
                alivePlayer.setMute(false);
            }
            if (alivePlayer.isHeal()) {
                alivePlayer.setHeal(false);
            }
            if (alivePlayer.isHealedWithDoc()) {
                alivePlayer.setHealedWithDoc(false);
            }
            if (alivePlayer.isHealedWithDocLec()) {
                alivePlayer.setHealedWithDoc(false);
            }
            if (alivePlayer.isKilledWithMafia()) {
                alivePlayer.setKilledWithMafia(false);
            }
            if (alivePlayer.isKilledWithSniper()) {
                alivePlayer.setKilledWithSniper(false);
            }
        }

        for (int i = 0; i < alivePlayers.size(); i++) {
            if (alivePlayers.get(i).isExecute) {
                this.executed = alivePlayers.get(i);
                this.deadPlayers.add(alivePlayers.get(i));
                alivePlayers.get(i).setAlive(false);
                alivePlayers.remove(alivePlayers.get(i));
                break;
            }
        }
    }

    public List<Player> getWinners() {
        List<Player> init = new ArrayList<>();
        int numberOfC = 0;
        int numberOfM = 0;
        for (Player alivePlayer : alivePlayers) {
            if (alivePlayer instanceof Mafia) {
                numberOfM++;
            } else if (alivePlayer instanceof Citizen) {
                numberOfC++;
            }
        }
        if (executed != null) {
            if (this.executed.equals(winnerJ)) {
                List<Player> winnerJoker = new ArrayList<>();
                winnerJoker.add(winnerJ);
                return winnerJoker;
            }
            init(numberOfM, numberOfC);
        }
        init(numberOfM, numberOfC);
        return init;
    }

    public List<Player> init(int numberOfM, int numberOfC) {
        if (numberOfM == 0) {
            return winnerC;
        } else if (numberOfM >= numberOfC + existJ) {
            return winnerM;
        }
        return new ArrayList<>();
    }
    //---------------------------------------------------methods------------------------------------------------------//
}