package gnaizel.inc.controller;

import gnaizel.inc.model.Film;
import gnaizel.inc.service.FilmService;
import gnaizel.inc.storage.film.FilmStorage;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/films")
@RequiredArgsConstructor
public class FilmController {
    private final FilmStorage filmStorage;
    private final FilmService filmService;

    @GetMapping("/{id}")
    public Film getFilmForId(@PathVariable int id) {
        return filmStorage.getFilm(id);
    }

    @GetMapping
    public Set<Film> getFilms() {
        return filmStorage.getFilms();
    }

    @PostMapping
    public Film postFilm(@Valid @RequestBody Film film) {
        return filmStorage.postFilm(film);
    }

    @PutMapping
    public Film updateFilm(@RequestBody Film film) {
        return filmStorage.updateFilm(film);
    }

    @GetMapping("/{id}/like/{userId}")
    public void likeFilm(@PathVariable int id, @PathVariable long userId) {
        filmService.addLike(userId, id);
    }

    @DeleteMapping("/{id}/like/{userId}")
    public void deleteLike(@PathVariable int id, @PathVariable long userId) {
        filmService.deleteLike(userId, id);
    }

    @GetMapping("/popular")
    public void getTop10(@RequestParam(required = false, defaultValue = "10") Integer count) {
        filmService.getTop10Films(count);
    }
}
