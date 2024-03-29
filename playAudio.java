import java.io.File;
import java.io.IOException;
 
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
 
/**
 * This is an example program that demonstrates how to play back an audio file
 * using the Clip in Java Sound API.
 * @author www.codejava.net
 *
 */
public class playAudio implements LineListener
{
	//Indicates whether the playback completes or not.
	boolean playCompleted = false;
	
	// Added by Joseph Telford - 3/9/2023 6:13PM
	private Clip audioClip;



	
	public void play(String audioFilePath)
	{
		File audioFile = new File(audioFilePath);
		
		
		
	
		try
		{
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			AudioFormat format = audioStream.getFormat();
	
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			audioClip = (Clip) AudioSystem.getLine(info);
	
			audioClip.addLineListener(this);
			audioClip.open(audioStream);
			
		
				audioClip.start();
		
			
			
		}
		catch (UnsupportedAudioFileException ex)
		{
			System.out.println("Error: The specified audio file is not supported.");
			ex.printStackTrace();
		}
		catch (LineUnavailableException ex)
		{
			System.out.println("Error: Audio line for playing back is unavailable.");
			ex.printStackTrace();
		}
		catch (IOException ex)
		{
			System.out.println("Error: Issue playing the audio file.");
			ex.printStackTrace();
		}
	// }
	
	//audioClip.close();
	
	}


	
	public void stop()
	{
		audioClip.close();
	}

	@Override
	public void update(LineEvent event)
	{
		LineEvent.Type eventType = event.getType();
		if (eventType == LineEvent.Type.START)
		{
			// Audio clip has started playing
		} 
		else if (eventType == LineEvent.Type.STOP) // || (playCompleted == true))
		{
			// Audio clip has stopped playing
			playCompleted = true;
			audioClip.close();
		}
	}
	
	
	// Generates a random Integer between 1 and 8 to determine which audio file is played on the Play Action Screen
	public static int generateRandomInteger()
	{
		// Minimum value of range
		int minValue = 1;
		// Maximum value of range
		int maxValue = 8;
		
		
		
		// Generate random int value from min to max
		int randomInteger = (int)Math.floor(Math.random() * (maxValue - minValue + 1) + minValue);
		
		return randomInteger;
	}


}