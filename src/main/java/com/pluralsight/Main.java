package com.pluralsight;

public class Main {
    public static void main(String[] args) {

        //Theme Intro
        System.out.println("──────────────────────────────────────────────");
        System.out.println("███╗   ███╗ █████╗ ███╗   ██╗███████╗██╗██╗  ██╗");
        System.out.println("████╗ ████║██╔══██╗████╗  ██║██╔════╝██║╚██╗██╔╝");
        System.out.println("██╔████╔██║███████║██╔██╗ ██║███████╗██║ ╚███╔╝ ");
        System.out.println("██║╚██╔╝██║██╔══██║██║╚██╗██║╚════██║██║ ██╔██╗ ");
        System.out.println("██║ ╚═╝ ██║██║  ██║██║ ╚████║███████║██║██╔╝ ██╗");
        System.out.println("╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚══════╝╚═╝╚═╝  ╚═╝");
        System.out.println("──────────────────────────────────────────────");
        System.out.println("        T O K Y O   G H O U L   L E D G E R");
        System.out.println("──────────────────────────────────────────────");
        System.out.println("\"The more you try to erase me, the more I'll haunt you.\" — Kaneki Ken");
        System.out.println();


        try {
            String[] intro = {
                    "Unraveling the mask...",
                    "Balancing hunger and humanity...",
                    "Entering the Tokyo Ghoul Ledger..."
            };
            for (String line : intro) {
                System.out.println(line);
                Thread.sleep(1000);
            }
            System.out.println();
        } catch (InterruptedException e) {

        }

        // Launch the actual program
        Homescreen.homeScreen();
    }
}