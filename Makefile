.PHONY: lint build install

lint:
	make -C app lint

build:
	make -C app build

install:
	make -C app install
