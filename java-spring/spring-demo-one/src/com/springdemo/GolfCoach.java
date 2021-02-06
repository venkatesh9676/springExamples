package com.springdemo;

public class GolfCoach implements Coach{
	
	private FortuneService fortuneService;
	public GolfCoach(FortuneService theFortuneService) {
		fortuneService=theFortuneService;
	}
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "practice ur putting skills for 2 hours day";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
