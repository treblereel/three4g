/** @type {HTMLCanvasElement} */
let _canvas;

const ImageUtils = {

	/**
	 * @param {HTMLCanvasElement|HTMLImageElement| ImageBitmap|undefined} image
	 * @return {string}
	 */
	getDataURL: function ( image ) {

		if ( /^data:/i.test( image.src ) ) {

			return image.src;

		}

		if ( typeof HTMLCanvasElement == 'undefined' ) {

			return image.src;

		}

		/** @type {HTMLCanvasElement} */
		let canvas;

		if ( image instanceof HTMLCanvasElement ) {

			canvas = image;

		} else {

			if ( _canvas === undefined ) _canvas =  /** @type {HTMLCanvasElement} */ (document.createElementNS( 'http://www.w3.org/1999/xhtml', 'canvas' ) );

			_canvas.width = image.width;
			_canvas.height = image.height;

			const context = /** @type {CanvasRenderingContext2D} */ (_canvas.getContext( '2d' ));

			if ( image instanceof ImageData ) {

				context.putImageData( image, 0, 0 );

			} else {

				context.drawImage( image, 0, 0, image.width, image.height );

			}

			canvas = _canvas;

		}

		if ( canvas.width > 2048 || canvas.height > 2048 ) {

			return canvas.toDataURL( 'image/jpeg', 0.6 );

		} else {

			return canvas.toDataURL( 'image/png' );

		}

	}

};

export { ImageUtils };
