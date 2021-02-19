var gulp = require('gulp');

gulp.task('copy', function () {
    return gulp.src('*.txt')
        .pipe(gulp.dest('test/'));
});

var sass = require('gulp-sass');
var autoprefixer = require('gulp-autoprefixer');
gulp.task('sass', function() {
    return gulp.src('scss/*.scss')
        .pipe(sass())
        .pipe(autoprefixer({
            browsers: ['chrome > 0', 'ie > 0', 'firefox > 0']
        }))
        .pipe(gulp.dest('css/'))
        .pipe(browserSync.stream({match:'**/*.css'})); // broswer-sync로 전송 추가
});

var imagemin = require('gulp-imagemin');
var buffer = require('vinyl-buffer');
var spritesmith = require('gulp.spritesmith');
gulp.task('sprite', function () {
    var spriteData = gulp.src('sprites/*.png')
        .pipe(spritesmith({
            imgName: 'sprite.png',
            cssName: '_sprite.scss',
            imgPath: '../img/sprite.png'
        }));
    var imgStream = new Promise(function (resolve) {
        spriteData.img
            .pipe(buffer())
            .pipe(imagemin())
            .pipe(gulp.dest('img/'))
            .on('end', resolve);
    });

    var cssStream = new Promise(function (resolve) {
        spriteData.css
            .pipe(gulp.dest('scss/'))
            .on('end', resolve);
    });

    return Promise.all([imgStream, cssStream]);
});

var browserSync = require('browser-sync');
gulp.task('browser-sync', function() {
    browserSync.init({
        server: {
            baseDir: "./"
        }
    });
});
// 다음은 파일이 수정 될 경우 자동으로 인식하고 동작하도록 watch task를 만듭니다.
gulp.task('watch',gulp.series(['browser-sync']),function() {
    gulp.watch('scss/*.scss',['sass']);
    gulp.watch('*.html').on('change', browserSync.reload);
});

gulp.task('default',gulp.series(['sass']));