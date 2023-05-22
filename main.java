import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Film {
    private String title;
    private String director;
    private int duration;
    private int availableSeats;

    public Film(String title, String director, int duration, int availableSeats) {
        this.title = title;
        this.director = director;
        this.duration = duration;
        this.availableSeats = availableSeats;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getDuration() {
        return duration;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void decreaseAvailableSeats() {
        availableSeats--;
    }
}

class Cinema {
    private List<Film> films;

    public Cinema() {
        films = new ArrayList<>();
    }

    public void addFilm(Film film) {
        films.add(film);
    }

    public void displayFilmList() {
        System.out.println("Film List:");
        for (Film film : films) {
            System.out.println("Title: " + film.getTitle());
            System.out.println("Director: " + film.getDirector());
            System.out.println("Duration: " + film.getDuration() + " minutes");
            System.out.println("Available Seats: " + film.getAvailableSeats());
            System.out.println("---------------------");
        }
    }

    public Film findFilmByTitle(String title) {
        for (Film film : films) {
            if (film.getTitle().equalsIgnoreCase(title)) {
                return film;
            }
        }
        return null;
    }
}

class FilmReservationSystem {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();

        cinema.addFilm(new Film("I'm the best", "Silent Death53", 148, 50));
        cinema.addFilm(new Film("You're the best", "Silent Death53", 152, 40));
        cinema.addFilm(new Film("We're the best", "Silent Death53", 159, 20));
        cinema.addFilm(new Film("Interstellar", "Christopher Nolan", 169, 30));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Film Reservation System ---");
            System.out.println("1. Display Film List");
            System.out.println("2. Reserve a Film");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    cinema.displayFilmList();
                    break;
                case 2:
                    System.out.print("Enter the film title: ");
                    String title = scanner.nextLine();
                    Film film = cinema.findFilmByTitle(title);
                    if (film != null) {
                        if (film.getAvailableSeats() > 0) {
                            System.out.println("Reservation successful!");
                            film.decreaseAvailableSeats();
                        } else {
                            System.out.println("No available seats for the selected film.");
                        }
                    } else {
                        System.out.println("Film not found.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
