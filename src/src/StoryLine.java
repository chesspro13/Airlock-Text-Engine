package src;

//package src;

public enum StoryLine
{
    //TODO: Add a file location for computer
	intro (StoryLine2.intro,"C:/Users/chess/Documents/NetBeansProjects/TextRPG/src/src/Story/intro.txt", "/storage/emulated/0/AppProjects/RandomRPGNormal/src/Story/intro.txt"),
	store1 (StoryLine2.store1,"C:/Users/chess/Documents/NetBeansProjects/TextRPG/src/src/Story/store1.txt", "/storage/emulated/0/AppProjects/RandomRPGNormal/src/Story/store1.txt"),
	dungeon1 (StoryLine2.dungeon1,"C:/Users/chess/Documents/NetBeansProjects/TextRPG/src/src/Story/intro.txt", "/storage/emulated/0/AppProjects/RandomRPGNormal/src/Story/dungeon1.txt"),
	battle (StoryLine2.battle,"C:/Users/chess/Documents/NetBeansProjects/TextRPG/src/src/Story/intro.txt", "/storage/emulated/0/AppProjects/RandomRPGNormal/src/Story/battle.txt");
	
	private final StoryLine2 state;
	private final String fileLocationComputer;
	private final String fileLocationPhone;
	
	StoryLine(StoryLine2 state, String fileLocationComputer, String fileLocationPhone)
	{
		this.state = state;
		this.fileLocationComputer = fileLocationComputer;
                this.fileLocationPhone = fileLocationPhone;
	}
	
	public StoryLine2 getState()
	{
		return this.state;
	}
	
	public String getFileLocationComputer()
	{
		return this.fileLocationComputer;
	}
	
	public String getFileLocationPhone()
	{
		return this.fileLocationPhone;
	}
	
}
