package football_team;

// Center implements FootballPlayer, Blocker, Snapper
// GuardTackle implement FootballPlayer, Blocker
// EndTightOrSplit implements FootballPlayer, Blocker, PassReceiver
// RunningBack implements FootballPlayer, BallCarrier, PassReceiver
// Fullback implements Blocker, FootballPlayer, BallCarrier, PassReceiver
// WideReceiver implements FootballPlayer, PassReceiver
// Quarterback implements FootballPlayer, Leader, BallCarrier
public interface FootballPlayer {
	
	void run();

	public interface Blocker {
		void block();
	}

	public interface PassReceiver {
		void _catch();
	}

	public interface BallCarrier {
		void run_with_ball();
		void receive_handoff();
	}

	public interface Snapper {
		void snap();
	}

	public interface Leader {
		void throw_pass();
		void handoff();
		void receive_snap();
	}

	public interface PassDefender {
		void cover_pass_receiver();
		void break_up_pass();
		void intercept_pass();
	}

}
