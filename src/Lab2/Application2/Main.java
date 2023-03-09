package Lab2.Application2;

import Lab2.Application2.Controllers.ThreadAnalysisController;

public class Main {
    public static void main(String[] args) {
        (new ThreadAnalysisController()).Start(20, 1000000);
    }
}
