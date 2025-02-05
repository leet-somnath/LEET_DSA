#include <raylib.h>

int main() {
    // Initialize the window
    InitWindow(800, 600, "Hello raylib");

    while (!WindowShouldClose()) {
        // Start drawing
        BeginDrawing();
        ClearBackground(RAYWHITE);
        DrawText("Hello, raylib!", 350, 280, 20, LIGHTGRAY);
        EndDrawing();
    }

    // Close window and clean up resources
    CloseWindow();
    return 0;
}
