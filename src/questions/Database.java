package questions;

public final class Database {
	private Database() {};
	public static final	HardQuestion[] HARDQUESTIONS = {new HardQuestion("How long is Venus� year (days)?", 225), new HardQuestion("How tall is the highest mountain on Venus? (miles)", 7), new HardQuestion("About how long does it take sunlight to reach Earth? (minutes)", 8), new HardQuestion("What year was Pluto officially discovered?", 1930), new HardQuestion("When was Pluto reclassified as a dwarf planet?", 2006), new HardQuestion("How many hours is one day on Jupiter?", 10), new HardQuestion("Roughly how many Earths could fit inside Neptune?", 58), new HardQuestion("How many years does it take Neptune to complete one lap around the sun?", 165), new HardQuestion("How many rings does Uranus have?", 13), new HardQuestion("How big are the nuclei of most comets (miles)?", 10), new HardQuestion("How many tails does a comet have?", 2), new HardQuestion("How many constellations have been formally named by the IAU?", 88), new HardQuestion("How high above the Earth does Hubble orbit? (miles)", 347), new HardQuestion("How many servicing missions were launched to repair or upgrade Hubble?", 5), new HardQuestion("How many of Pluto's five known moons has Hubble discovered?", 4), new HardQuestion("Hubble photographed Comet Shoemaker-Levy 9's spectacular crash into Jupiter in what year?", 1994) };
	public static final EasyQuestion[] EASYQUESTIONS = { new EasyQuestion("The first bulgarian cosmonaut is:\n A) Georgi Ivanov\n B) Alexander Alexandrov", 'A'), new EasyQuestion("If the sun was spontaneously replaced by a black hole of equal mass, Earth would get sucked in.\n A) True \n B) False", 'B'), new EasyQuestion("Saturn is named for the ancient Roman god of what?\n A) Jewelry\n B) Agriculture", 'B'), new EasyQuestion("Does Jupiter have rings?\n A) Yes\n B) No", 'A'), new EasyQuestion("Which component of the Milky Way makes up most of its mass?\n A) Stars\n B) Dark matter", 'B'), new EasyQuestion("Neptune has 13 known moons. What's the name of the largest one?\n A) Triton \n B) Titania", 'A'), new EasyQuestion("Who discovered the planet Uranus in 1781?\n A) Einstein\n B) William Herschel", 'B'), new EasyQuestion("True or false: Uranus is invisible to the naked eye in the night sky. \n A) True\n B) False", 'B'), new EasyQuestion("What type of planet is Uranus?\n A) A gas giant\n B) Captain Planet", 'A'), new EasyQuestion("Can you breathe in the space? \n A) Yes \n B) No", 'B'), new EasyQuestion("Do heavier objects fall more slowly than lighter objects? \n A) No \n B) Yes", 'A'), new EasyQuestion("What is the difference between energy and power? \n A) There is no difference \n B)Power is the rate of energy being generated or consumed", 'B'), new EasyQuestion("Who joined Neil Armstrong and Buzz Aldrin on the Apollo 11 mission?\n A) Michael Collins\n B) Jim Lovell", 'A'), new EasyQuestion("Apollo 11 launched on a 363-foot-tall rocket called what? \n A) Jupiter C \n B) Saturn V", 'B'), new EasyQuestion("What was the first phrase spoken on the moon? \n A) Houston, Tranquility Base here.\n B) Contact light.", 'B'), new EasyQuestion("What is the nucleus of a comet primarily made of? \n A) Ice and dust \n B) Rock", 'A'), new EasyQuestion("Which comet smashed into Jupiter in 1994? \n A) Hale-Bopp \n B) Shoemaker-Levy 9", 'B'), new EasyQuestion("True or False: Chinese astronomers kept records of comet sightings for centuries. They even tracked Halley's Comet as far back as 240 BC. \n A) True \n B) False", 'A') };
	public static final MediumQuestion[] MEDIUMQUESTIONS = { new MediumQuestion("General relativity predicts that black holes have: \n A) Infinite mass\n B) Infinite destiny\n C) Infinite volume", 'B'), new MediumQuestion("What is the major constituent of Saturn's rings, making up more than 90 percent of their mass?\n A) Diamonds \n B) Water Ice\n C) Carbon", 'B'), new MediumQuestion("About how many stars, on order, are in the Milky Way?\n A) 100 Billion\n B) 100 Million", 'A'), new MediumQuestion("Which type of galaxy is the Milky Way?\n A) Elliptical\n B) Barred spiral\n C) Unbarred spiral", 'B'), new MediumQuestion("What are comets often called?\n A) Silly Streakers \n B) Filthy dirt balls \n C) Dirty snowballs", 'C'), new MediumQuestion("Where do many comets come from?\n A) The Oort Cloud \n B) The Moon \n C) Mercury", 'A'), new MediumQuestion("Who was Orion the Hunter?\n A) A guy who liked archery\n B) A hero in Greek mythology\n C) A hero in Roman mythology", 'B'), new MediumQuestion("What are the only two animal constellations with identical Latin and English names?\n A) Puma and Serpent\n B) Aries and Taurus \n C) Lynx and Phoenix", 'C'), new MediumQuestion("Which space shuttle carried Hubble to orbit in April 1990? \n A) Endeavour\n B) Atlantis\n C) Enterprise\n D) Discovery", 'D'), new MediumQuestion("What�s Earth�s true shape?\n A) Sphere\n B) Flat \n C) Oblate Spheroid", 'C'), new MediumQuestion("67,000 mph (107,826 km/h) represents what speed?\n A) Earth's Orbit around the sun\n B) Earth's rotation about its axis", 'A'), new MediumQuestion("Roughly how old is Earth?\n A) 4.5 Billion years\n B) 4.5 Million years", 'A'), new MediumQuestion("134 degrees Fahrenheit (56.7 degrees C) was the hottest temperature ever measured on Earth. Where?\n A) The North Pole\n B) Death Valley, California\n C) El Azizia, Libya", 'B'), new MediumQuestion("Lightning strike somewhere on Earth 100 times per: \n A) Day\n B) Year\n C) Second", 'C') };
	public static final void resetForNewGame()
	{
		for (int i = 0; i < EASYQUESTIONS.length; i++) {
			EASYQUESTIONS[i].reset();
		}
		for (int i = 0; i < HARDQUESTIONS.length; i++) {
			HARDQUESTIONS[i].reset();
		}
		for (int i = 0; i < MEDIUMQUESTIONS.length; i++) {
			MEDIUMQUESTIONS[i].reset();
		}
	}


}