package com.softcondominios.api.rest.dto;

public class TimeDto {
		private String data;
		private String hora;
		
		
		public TimeDto() {
			// TODO Auto-generated constructor stub
		}

		

		public TimeDto(String data, String hora) {
			super();
			this.data = data;
			this.hora = hora;
		}



		public String getData() {
			return data;
		}


		public void setData(String data) {
			this.data = data;
		}


		public String getHora() {
			return hora;
		}


		public void setHora(String hora) {
			this.hora = hora;
		}
		
		
}
