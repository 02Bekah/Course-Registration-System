/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cs3700.courseregistrationsystem;

/**
 *
 * @author Jon
 */
public class Program {
        public String Name;
        public String College;
        private String Type;
        private int Num_credits;
        
        public String getType(){
            return(Type);
        }
        
        public int getNum_credits(){
            return(Num_credits);
        }
        
        public int setType(String Type){
            if (Type.equalsIgnoreCase("traditional")|| 
                    Type.equalsIgnoreCase("online")|| Type.equalsIgnoreCase("unknown")){
                this.Type = Type;
                return 0;
            }
            return 1;
        }
        
        public int setNum_credits(int Num_credits){
            if (Num_credits > 0){
                this.Num_credits = Num_credits;
                return 0;
            }
            return 1;
        }
        public Program(String Name, String College, String Type, int Num_credits){
            this.Name = Name;
            this.College = College;
            setType(Type);
            setNum_credits(Num_credits);
        }
        public Program(){
            this("unknown", "unknown", "unknown", 0);
        }
    }