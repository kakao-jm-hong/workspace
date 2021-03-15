```
var gulp = require('gulp');
var sass = require('gulp-sass');
gulp.task('sass', function () {
    console.log('sass start');
    return gulp.src('src/scss/*.scss')
        .pipe(sass())
        .pipe(gulp.dest('src/css/'))
        .pipe(browserSync.stream({match:'./src/**/*.css'}));
});

var imagemin = require('gulp-imagemin');
var buffer = require('vinyl-buffer');
var spritesmith = require('gulp.spritesmith');

gulp.task('sprite', function () {
    var spriteData = gulp.src('src/png-sprite/*.png')
        .pipe(spritesmith({
            retinaSrcFilter: 'src/png-sprite/*@2x.png',
            imgName: 'sprite.png',
            retinaImgName:'../img/sprite2.png',
            cssName: '_sprite.scss',
            imgPath: '../img/sprite.png',
        }));
    var imgStream = new Promise(function (resolve) {
        spriteData.img
            .pipe(buffer())
            .pipe(imagemin())
            .pipe(gulp.dest('src/img/'))
            .on('end', resolve);
    });

    var cssStream = new Promise(function (resolve) {
        spriteData.css
            .pipe(gulp.dest('src/scss/'))
            .on('end', resolve);
    });

    return Promise.all([imgStream, cssStream]);
});

var browserSync = require('browser-sync');
gulp.task('watch', function () {
    browserSync.init({
        server: {
            baseDir: "./src",
            index: "/index.html"
        }
    });
    gulp.watch('./src/scss/**/*.scss', gulp.series(['sass'])); 
    gulp.watch('./src/*.html').on('change', browserSync.reload); 
});

gulp.task('default',gulp.series(['watch']));
```