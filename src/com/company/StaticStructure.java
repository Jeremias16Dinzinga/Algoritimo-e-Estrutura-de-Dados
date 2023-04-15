package com.company;

public class StaticStructure<T> {
    protected T[] Element;
    protected int Size;

    public StaticStructure(int capacity) {
        this.Element = (T[]) new Object[capacity];
        this.Size = 0;

    }

    public StaticStructure() {
        this(12);
    }

    public T getElement(int pos) {
        return Element[pos];
    }

    public void setElement(int pos, T element) {
        Element[pos] = element;
    }

    public int Size() {
        return Size;
    }

    public boolean Add(T element) {
        this.AddCapacity();
        if (this.Size < this.Element.length) {
            this.Element[Size] = element;
            Size++;
            return true;
        }
        return false;
    }

    public boolean IsEmpty() {
        return this.Size == 0;
    }

    public boolean Add(int pos, T element) {
        if (pos < 0 || pos > Size) {
            throw new IllegalArgumentException("Posição inválida");
        }
        this.AddCapacity();
        for (int i = this.Size - 1; i >= pos; i--) {
            this.Element[i + 1] = this.Element[i];
        }
        this.Element[pos] = element;
        this.Size++;

        return true;
    }

    public void AddCapacity() {
        if (this.Size == this.Element.length) {
            T[] newElement = (T[]) new Object[this.Element.length * 2];
            for (int i = 0; i < this.Element.length; i++) {
                newElement[i] = this.Element[i];
            }
            this.Element = newElement;
        }

    }

    public void Remove(int pos) {
        if (!(pos >= 0 && pos < Size)) {
            throw new IllegalArgumentException("Posicao inválida");
        }
        for (int i = pos; i < Size - 1; i++) {
            Element[i] = Element[i + 1];
        }
        Size--;
    }

    @Override
    public String toString() {

        StringBuilder s = new StringBuilder();
        s.append("[");

        for (int i = 0; i < this.Size - 1; i++) {
            s.append(this.Element[i]);
            s.append(", ");
        }

        if (this.Size > 0) {
            s.append(this.Element[this.Size - 1]);
        }

        s.append("]");

        return s.toString();
    }
}
