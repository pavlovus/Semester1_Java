public enum Weekd {
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
		
		public Weekd getNextDay(){
			if(this.ordinal() == 6){
				return Weekd.values()[0];
			}
			return Weekd.values()[this.ordinal() + 1];
		}
}

