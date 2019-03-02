package src;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class CircleLayout implements LayoutManager {
    private double radiusFactor;

    public CircleLayout(double radiusFactor) {
        this.radiusFactor = radiusFactor;
    }

    public CircleLayout() {
        this(0.75);
    }

    public void layoutContainer(Container parent) {
        Component component;
        Dimension preferedSize;
        int componentCount = parent.getComponentCount();
        int centerX = getCenterX(parent);
        int centerY = getCenterY(parent);

        if (componentCount == 1) {
            component = parent.getComponent(0);
            preferedSize = component.getPreferredSize();
            component.setBounds(centerX, centerY, preferedSize.width, preferedSize.height);
        } else {
            double radius = getRadius(parent);
            for (int i = 0; i < componentCount; i++) {
                component = parent.getComponent(i);
                preferedSize = component.getPreferredSize();
                component.setBounds(getComponentX(componentCount, i, centerX, radius),
                                    getComponentY(componentCount, i, centerY, radius),
                                    preferedSize.width,
                                    preferedSize.height);
            }
        }
    }

    private int getComponentX(int partsCount, int componentNumber, int centerX, double radius) {
        return (int) (radius * Math.cos(2 * componentNumber * Math.PI / partsCount)) + centerX;
    }

    private int getComponentY(int partsCount, int componentNumber, int centerY, double radius) {
        return (int) (radius * Math.sin(2 * componentNumber * Math.PI / partsCount)) + centerY;
    }

    private int getCenterX(Container parent) {
        Insets insets = parent.getInsets();
        return (int) (parent.getSize().width - (insets.left + insets.right)) / 2;
    }

    private int getCenterY(Container parent) {
        Insets insets = parent.getInsets();
        return (int) (parent.getSize().height - (insets.top + insets.bottom)) / 2;
    }


    private double getRadius(Container parent) {
        Insets insets = parent.getInsets();
        double parentWidth = parent.getSize().width;
        double parentHeight = parent.getSize().height;
        return (Math.min(parentWidth - (insets.left + insets.right),
                         parentHeight - (insets.top + insets.bottom)))
                / 2 * radiusFactor;
    }

    public Double getRadiusFactor() {
        return radiusFactor;
    }

    public void setRadiusFactor(double radiusFactor) {
        this.radiusFactor = radiusFactor;
    }

    public Dimension preferredLayoutSize(Container target) {
        return target.getSize();
    }

    public Dimension minimumLayoutSize(Container target) {
        return target.getSize();
    }

    public void addLayoutComponent(String name, Component component) {
    }

    public void removeLayoutComponent(Component component) {
    }

    public String toString() {
        return this.getClass().getName() + "[radiusFactor = " + radiusFactor + "]";
    }
}
