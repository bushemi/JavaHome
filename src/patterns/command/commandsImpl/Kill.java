package patterns.command.commandsImpl;

public class Kill implements CommandInterface {

	@Override
	public void execute() {
		System.out.println("Shut up! I'll kill you!");

	}

}
