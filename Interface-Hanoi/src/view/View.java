package view;
import model.ModeloRectangulo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.LinkedList;

public class VistaRectangulo extends JPanel {
        private Collection<ModeloRectangulo> rectangulosMovibles = new LinkedList<>();
        private Collection<ModeloRectangulo> rectangulosFijos = new LinkedList<>();
        private Collection<ModeloRectangulo> rectangulosNoMovibles = new LinkedList<>();
        private ModeloRectangulo rectanguloSeleccionado = null;
    public VistaRectangulo() {

        rectangulosMovibles.add(new ModeloRectangulo(100, 300, Color.RED, 60, 20));
        rectangulosMovibles.add(new ModeloRectangulo(90, 320, Color.GREEN, 80, 20));
        rectangulosMovibles.add(new ModeloRectangulo(80, 340, Color.BLUE, 100, 20));

        rectangulosFijos.add(new ModeloRectangulo(90, 360, Color.DARK_GRAY, 80, 3));
        rectangulosFijos.add(new ModeloRectangulo(200, 360, Color.DARK_GRAY, 80, 3));
        rectangulosFijos.add(new ModeloRectangulo(320, 360, Color.DARK_GRAY, 80, 3));

        // Agregar rectángulos sin colisiones y no movibles
        rectangulosNoMovibles.add(new ModeloRectangulo(120, 210, Color.GRAY, 20, 150));
        rectangulosNoMovibles.add(new ModeloRectangulo(230, 210, Color.GRAY, 20, 150));
        rectangulosNoMovibles.add(new ModeloRectangulo(350, 210, Color.GRAY, 20, 150));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                for (ModeloRectangulo modelo : rectangulosMovibles) {
                    if (modelo.getX() <= e.getX() && e.getX() <= modelo.getX() + modelo.getWidth() &&
                            modelo.getY() <= e.getY() && e.getY() <= modelo.getY() + modelo.getHeight()) {
                        rectanguloSeleccionado = modelo;
                        break;
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                rectanguloSeleccionado = null;
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (rectanguloSeleccionado != null) {
                    int newX = e.getX() - rectanguloSeleccionado.getWidth() / 2;
                    int newY = e.getY() - rectanguloSeleccionado.getHeight() / 2;

                    // Evitar que el rectángulo se salga del panel
                    newX = Math.max(0, Math.min(getWidth() - rectanguloSeleccionado.getWidth(), newX));
                    newY = Math.max(0, Math.min(getHeight() - rectanguloSeleccionado.getHeight(), newY));

                    // Comprobar colisiones con rectángulos fijos
                    boolean colisionFijos = false;
                    for (ModeloRectangulo rectanguloFijo : rectangulosFijos) {
                        if (newX < rectanguloFijo.getX() + rectanguloFijo.getWidth() &&
                                newX + rectanguloSeleccionado.getWidth() > rectanguloFijo.getX() &&
                                newY < rectanguloFijo.getY() + rectanguloFijo.getHeight() &&
                                newY + rectanguloSeleccionado.getHeight() > rectanguloFijo.getY()) {
                            colisionFijos = true;
                            break;
                        }
                    }

                    // Comprobar colisiones con rectángulos móviles
                    boolean colisionMovibles = false;
                    for (ModeloRectangulo rectanguloMovible : rectangulosMovibles) {
                        if (rectanguloSeleccionado != rectanguloMovible &&
                                newX < rectanguloMovible.getX() + rectanguloMovible.getWidth() &&
                                newX + rectanguloSeleccionado.getWidth() > rectanguloMovible.getX() &&
                                newY < rectanguloMovible.getY() + rectanguloMovible.getHeight() &&
                                newY + rectanguloSeleccionado.getHeight() > rectanguloMovible.getY()) {
                            colisionMovibles = true;
                            break;
                        }
                    }

                    if (!colisionFijos && !colisionMovibles) {
                        rectanguloSeleccionado.setPosicion(newX, newY);
                        repaint();
                    }
                }
            }
        });
    }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            for (ModeloRectangulo rectanguloNoMovible : rectangulosNoMovibles) {
                g.setColor(rectanguloNoMovible.getColor());
                g.fillRect(rectanguloNoMovible.getX(), rectanguloNoMovible.getY(), rectanguloNoMovible.getWidth(), rectanguloNoMovible.getHeight());
            }

            for (ModeloRectangulo rectanguloFijo : rectangulosFijos) {
                g.setColor(rectanguloFijo.getColor());
                g.fillRect(rectanguloFijo.getX(), rectanguloFijo.getY(), rectanguloFijo.getWidth(), rectanguloFijo.getHeight());
            }

            for (ModeloRectangulo rectanguloMovible : rectangulosMovibles) {
                g.setColor(rectanguloMovible.getColor());
                g.fillRect(rectanguloMovible.getX(), rectanguloMovible.getY(), rectanguloMovible.getWidth(), rectanguloMovible.getHeight());
            }

        }
}


