package Catalogo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Modelos.MCategoria;
import Modelos.MProducto;

/**
 * Servlet implementation class Catalogo
 */
@WebServlet("/Catalogo")
public class Catalogo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int numeroCategorias;
	HttpSession sesion;
	MCategoria mCategoria = new MCategoria();
	MProducto mProducto = new MProducto();
	String[] categorias;
	Cproducto[] listaProductos;
	int ContadorCategorias;
	int contadorProductos;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected int numeroCategorias() {

		try {
			numeroCategorias = 1;
			mCategoria.cargarCategorias();
			while (mCategoria.consultarSiguiente()) {
				numeroCategorias++;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return numeroCategorias;

	}

	protected String[] almacenarCategorias() {
		try {
			categorias = new String[numeroCategorias()];
			mCategoria.cargarCategorias();
			ContadorCategorias = 0;
			do {
				categorias[ContadorCategorias] = mCategoria.getnombreCategoria();
				ContadorCategorias++;
			} while (mCategoria.consultarSiguiente());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return categorias;
	}

	protected Cproducto[] almacenarProductos() {
		listaProductos = new Cproducto[25];
		mProducto.cargarProductos();
		contadorProductos = 0;
		try {
			do {
				listaProductos[contadorProductos] = new Cproducto(mProducto.getIdreferencia(), mProducto.getNombre(),
						mProducto.getMarca(), mProducto.getDescripcion(), mProducto.getPrecio(), mProducto.getImg(),
						mProducto.getStock(), mProducto.getSubcategoria());
				contadorProductos++;
			} while (mProducto.consultarSiguiente());
		} catch (Exception e) {
			// TODO: handle exception
		}

		return listaProductos;

	}

	protected Cproducto[] almacenarProductosPorCategorias(int idCategoria) {
		listaProductos = new Cproducto[25];
		mProducto.cargarProductosPorCategorias(idCategoria);

		contadorProductos = 0;
		try {
			do {
				listaProductos[contadorProductos] = new Cproducto(mProducto.getIdreferencia(), mProducto.getNombre(),
						mProducto.getMarca(), mProducto.getDescripcion(), mProducto.getPrecio(), mProducto.getImg(),
						mProducto.getStock(), mProducto.getSubcategoria());
				contadorProductos++;
			} while (mProducto.consultarSiguiente());

		} catch (Exception e) {
			// TODO: handle exception
		}

		return listaProductos;

	}

	protected Cproducto[] almacenarProductosPorSubcategorias(int idSubcategoria) {
		listaProductos = new Cproducto[25];
		mProducto.cargarProductosPorSubcategorias(idSubcategoria);

		contadorProductos = 0;
		try {
			do {
				listaProductos[contadorProductos] = new Cproducto(mProducto.getIdreferencia(), mProducto.getNombre(),
						mProducto.getMarca(), mProducto.getDescripcion(), mProducto.getPrecio(), mProducto.getStock(),
						mProducto.getCategoria(), mProducto.getSubcategoria(), mProducto.getNombreCategoria(),
						mProducto.getNombreSubcategoria());
				;
				contadorProductos++;
			} while (mProducto.consultarSiguiente());

		} catch (Exception e) {
			// TODO: handle exception
		}

		return listaProductos;

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		sesion = request.getSession(true);
		if (sesion.getAttribute("Validacion") == null) {
			sesion.setAttribute("Validacion", (int) (Math.random() * 999999 + 1));
		}
		sesion.setAttribute("Categorias", almacenarCategorias());

		/*
		 * Carga de cat�logo por categar�a
		 */
		if (request.getParameter("idcategoria") != null) {
			/**
			 * Carga de cat�logo con b�squeda por categorias
			 */
			sesion.setAttribute("Productos",
					almacenarProductosPorCategorias(Integer.parseInt(request.getParameter("idcategoria"))));
		} else {

			if (request.getParameter("idsubcategoria") != null) {
				/**
				 * Carga de cat�logo con b�squeda por subcategorias
				 */
				sesion.setAttribute("Productos",
						almacenarProductosPorSubcategorias(Integer.parseInt(request.getParameter("idsubcategoria"))));
			} else {
				sesion.setAttribute("Productos", almacenarProductos());
			}
		}

		request.getRequestDispatcher("WEB-INF/catalogo.jsp").forward(request, response);

	}

}